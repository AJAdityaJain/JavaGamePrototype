package dev.code.game.States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import dev.code.game.Game;
import dev.code.game.StructGen.Dungeon;
import dev.code.game.entities.Entities;
import dev.code.game.entities.allEntities.Player;
import dev.code.game.entities.allEntities.Zombie;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.gfx.Text;

public class GameState extends State {
	public static Dungeon dungeon;
	public static Player player;
	public static int healthStatic;
	public static ArrayList<Text> TextArr = new ArrayList<Text>();
	public static int miniMapScale = 10;
	public int timer = 0;
	
	public GameState(int timer) {
		this.timer = timer*20;
		dungeon = new Dungeon();
		dungeon.floors.forEach(f->{
			f.Rooms.forEach(r ->{
				r.create();
			});
		});
		player = new Player(740,300,0);
		healthStatic = player.health*100;
		new Zombie(0,500,0);
//		new Mummy(0,0,0);
	}
	
	public void tick(){
		timer--;
		if(timer == 0){
			Game.CurrentState = Game.MenuState;
		}
		player.dir[0] = Game.keyManager.getKeys()[KeyEvent.VK_W];
		player.dir[1] = Game.keyManager.getKeys()[KeyEvent.VK_D];
		player.dir[2] = Game.keyManager.getKeys()[KeyEvent.VK_S];
		player.dir[3] = Game.keyManager.getKeys()[KeyEvent.VK_A];
		dungeon.floors.get(player.z).Entities.forEach(ent ->{
				if(ent.alive ) {
					ent.path();
					ent.HurtCooldown -= 1;
					if(ent.HurtCooldown < 0) {
						ent.HurtCooldown = 0;
					}
					ent.move();
				}
				else {
					ArrayList<Entities> narr = new ArrayList<Entities>();
					dungeon.floors.get(player.z).Entities.forEach(en ->{
						if(en.alive) {
							narr.add(en);
						}
					});
					dungeon.floors.get(player.z).Entities = narr;
				}

			});	
		ArrayList<Text> narr = new ArrayList<Text>();
		TextArr.forEach(el ->{
			if(el.Opacity > 0) {
				narr.add(el);
			}
		});
		TextArr = narr;
	}
	
	public void render(Graphics g) {
		if(!player.inv) {
			dungeon.floors.get(player.z).Rooms.forEach(r->{
				g.drawRect(r.x- player.x+740, r.y - player.y + 300, r.width, r.height);
				if(new Rectangle(player.x,player.y,player.width, player.height).intersects(new Rectangle(r.x,r.y,r.width,r.height))) {
					g.clearRect(r.x+740 - GameState.player.x, r.y+300 - GameState.player.y, r.width, r.height);
					r.Objects.forEach(o ->{
						o.render(g);
					});
					
				}
			});
			dungeon.floors.get(player.z).Entities.forEach(ent ->{
				if(ent.alive) {
					ent.render(g);
				}
			});	
			
			TextArr.forEach(el ->{
				Text.drawString(g, el.str, el.xPos- player.x+740, el.yPos- player.y + 300, true, el.colour, el.Font);
				el.colour = new Color(el.colour.getRed(), el.colour.getGreen(), el.colour.getBlue(),el.Opacity);
				el.Opacity-= 17;
			});
			
			
			g.setColor(new Color(200,128,128));
			g.fillRect(144,8,(int)(112 *healthStatic/(player.thealth*100)),22 );
			g.setColor(new Color(255,0,12));
			g.fillRect(144,8,(int)(112 *player.health/player.thealth),22 );
			g.setColor(new Color(0,93,255));
			g.fillRect(144,39,(int)(112 *player.defence/90),22 );
			g.setColor(new Color(73,255,0));
			g.fillRect(144,70,(int)(112 *(player.speedx+player.speedy)/30),22 );
			g.drawImage(ImgAssets.StatGui1,0, 0, 306,100, null);
			if(healthStatic >player.health*100) {
				healthStatic -= 10;
			}
			g.setColor(new Color(111,96,106));
			g.fillRect(1325, 25, 150, 150);
			dungeon.floors.get(player.z).Entities.forEach(el ->{
				if(Math.abs(el.x - player.x+50)/miniMapScale < 75&&Math.abs(el.y - player.y+50)/miniMapScale < 75) {
					g.drawImage(el.pointer, (el.x - player.x)/miniMapScale + 1400, (el.y - player.y)/miniMapScale + 100, el.height/miniMapScale, el.height/miniMapScale, null);					
				}
			});
			g.setColor(new Color(83,64,76));
			dungeon.floors.get(player.z).Rooms.forEach(r ->{
				r.Objects.forEach(el ->{
					Rectangle r1 = new Rectangle(1325,25,150,150);
					Rectangle r2 = new Rectangle(
							(el.boundingBox.x - player.x)/miniMapScale + 1400, (el.boundingBox.y - player.y)/miniMapScale + 100, 
							el.boundingBox.width/miniMapScale,
							el.boundingBox.height/miniMapScale);
					if(r1.contains(r2)) {
						g.fillRoundRect(r2.x,r2.y,r2.width,r2.height,2,2);		
						
					}
					else if(r1.intersects(r2)){
						if(r2.x < r1.x) {
							r2.width = r2.x+r2.width - r1.x;
							r2.x = r1.x;
						}
						if(r2.y < r1.y) {
							r2.height = r2.y+r2.height - r1.y;
							r2.y = r1.y;
						}
						if(r2.height + r2.y > r1.height + r1.y) {
							r2.height = r1.y+r1.height- r2.y;
						}
						if(r2.width + r2.x > r1.width + r1.x) {
							r2.width = r1.x+r1.width- r2.x;
						}
						g.fillRoundRect(r2.x,r2.y,r2.width,r2.height,2,2);		
					}
				});
			});
			g.drawImage(ImgAssets.StatGui2,1300, 0, 200,481, null);//((timer/20)%60)
			
			g.drawImage(ImgAssets.timerBG, 690, 702, 160, 64, null);
			Text.drawString(g, String.format("%02d", Math.floorDiv(timer/20, 60)) + ":" + String.format("%02d", ((timer/20)%60)), 770, 740, true, Color.red, Game.font);
		}
		else {
			player.Inventory.render(g,700,100);
		}
	}
}