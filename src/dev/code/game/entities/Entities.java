package dev.code.game.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.code.game.Game;
import dev.code.game.States.GameState;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.gfx.Text;
import dev.code.game.ui.Inventory;

public abstract class Entities {
	public int x;
	public int y;
	public int z;
	public int width;
	public int height;
	public int health;
	public int thealth;
	public int speedx;
	public int speedy;
	public int attack;
	public int defence = 0;
	public int sizeScale = 3;
	public int imgScale = 1;
	public BufferedImage Image;
	public boolean[] dir = {false,false,false,false};
	public int direction = 0;
	public boolean punching = false;
	public boolean punching2 = false;
	public int HurtCooldown = 0;
	public boolean alive = true;
	public Inventory Inventory = new Inventory(false);
	public int Index = 0;
	public int Index2 = 0;
	public int IndexInc = speedy;
	public int TotalIndex = 20;
	public BufferedImage pointer = ImgAssets.pointerAggressive;
	
	public Entities(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void render(Graphics g){
		g.drawRect(x+740 - GameState.player.x, y+300 - GameState.player.y, width, height);
		if(direction == 0) {
			g.drawImage(Image.getSubimage(28*imgScale, 12*imgScale, 4*imgScale, 11*imgScale),
			x + 740 - GameState.player.x+4*sizeScale, 29*sizeScale+y+300 - GameState.player.y-(Index),4*sizeScale,11*sizeScale, null);
			g.drawImage(Image.getSubimage(28*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 
			x + 740 - GameState.player.x+10*sizeScale, 29*sizeScale+y+300 - GameState.player.y-(TotalIndex-Index)-sizeScale,4*sizeScale,11*sizeScale , null);

			g.drawImage(Image.getSubimage(32*imgScale, 0*imgScale, 10*imgScale, 29*imgScale), 
			x + 4*sizeScale+740 - GameState.player.x, y+300 - GameState.player.y,10*sizeScale,29*sizeScale, null);
			
			if(punching) {
				g.drawImage(Image.getSubimage(28*imgScale, 29*imgScale, 4*imgScale, 6*imgScale), 
				x + 740 - GameState.player.x+14*sizeScale, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,6*sizeScale, null);
			}else {
				g.drawImage(Image.getSubimage(28*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x+14*sizeScale, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,12*sizeScale-(Index), null);				
			}
			if(punching2) {
				g.drawImage(Image.getSubimage(28*imgScale, 29*imgScale, 4*imgScale, 6*imgScale),
				x + 740 - GameState.player.x, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,6*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(28*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,12*sizeScale-(TotalIndex-Index), null);				
			}
		}
		if(direction == 2) {
			g.drawImage(Image.getSubimage(0*imgScale, 12*imgScale, 4*imgScale, 11*imgScale),
			x + 740 - GameState.player.x+4*sizeScale, 29*sizeScale+y+300 - GameState.player.y-(Index),4*sizeScale,11*sizeScale, null);
			
			g.drawImage(Image.getSubimage(0*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 					
			x + 740 - GameState.player.x+10*sizeScale, 29*sizeScale+y+300 - GameState.player.y-(TotalIndex-Index)-sizeScale,4*sizeScale,11*sizeScale , null);

			g.drawImage(Image.getSubimage(4*imgScale, 0*imgScale, 10*imgScale, 29*imgScale), 
			x + 4*sizeScale+740 - GameState.player.x, y+300 - GameState.player.y,10*sizeScale,29*sizeScale, null);
			
			if(punching) {
				g.drawImage(Image.getSubimage(0*imgScale, 29*imgScale, 4*imgScale, 6*imgScale), 
				x + 740 - GameState.player.x+14*sizeScale, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,6*sizeScale, null);

			}else {
				g.drawImage(Image.getSubimage(0*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x+14*sizeScale, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,12*sizeScale-(Index), null);
				
			}	
			if(punching2) {
				g.drawImage(Image.getSubimage(0*imgScale, 29*imgScale, 4*imgScale, 6*imgScale), 
				x + 740 - GameState.player.x, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,6*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(0*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,12*sizeScale-(TotalIndex-Index), null);				
			}
		}
		
		if(direction == 1) {
			if(punching) {
				g.drawImage(Image.getSubimage(42*imgScale, 29*imgScale, 12*imgScale, 4*imgScale),
				x + 740 - GameState.player.x + 13*sizeScale, y+300 - GameState.player.y + 10*sizeScale,12*sizeScale,4*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(42*imgScale, 0*imgScale, 4*imgScale, 12*imgScale),
				x + 740 - GameState.player.x + 13*sizeScale- (Index), y+300 - GameState.player.y + 10*sizeScale,4*sizeScale,12*sizeScale, null);				
			}

			g.drawImage(Image.getSubimage(46*imgScale, 0*imgScale, 10*imgScale, 29*imgScale),
				x+ 740 - GameState.player.x + 5*sizeScale, y+300 - GameState.player.y,10*sizeScale,29*sizeScale, null);
			
			if(punching2) {
				g.drawImage(Image.getSubimage(42*imgScale, 29*imgScale, 12*imgScale, 4*imgScale),
				x + 740 - GameState.player.x + 9*sizeScale, y+300 - GameState.player.y + 11*sizeScale,12*sizeScale,4*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(42*imgScale, 0*imgScale, 4*imgScale, 12*imgScale),
				x + 740 - GameState.player.x + 9*sizeScale-(TotalIndex-(Index)), y+300 - GameState.player.y + 11*sizeScale,4*sizeScale,12*sizeScale, null);				
			}
			
			g.drawImage(Image.getSubimage(42*imgScale, 12*imgScale, 4*imgScale, 11*imgScale),
			x + 740 - GameState.player.x+11*sizeScale -(TotalIndex-(Index)), 29*sizeScale+y+300 - GameState.player.y,4*sizeScale,11*sizeScale , null);
			g.drawImage(Image.getSubimage(42*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 
			x + 740 - GameState.player.x+10*sizeScale - (Index), 29*sizeScale+y+300 - GameState.player.y,4*sizeScale,11*sizeScale , null);
		}
		if(direction == 3) {
			if(punching2) {
				g.drawImage(Image.getSubimage(14*imgScale, 29*imgScale, 12*imgScale, 4*imgScale), 
				x + 740 - GameState.player.x + 6*sizeScale - 10*sizeScale, y+300 - GameState.player.y + 10*sizeScale,12*sizeScale,4*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(14*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x + 6*sizeScale- (Index), y+300 - GameState.player.y + 10*sizeScale,4*sizeScale,12*sizeScale, null);				
			}

			g.drawImage(Image.getSubimage(18*imgScale, 0*imgScale, 10*imgScale, 29*imgScale),
			x+ 740 - GameState.player.x + 5*sizeScale, y+300 - GameState.player.y,10*sizeScale,29*sizeScale, null);
			
			if(punching) {
				g.drawImage(Image.getSubimage(14*imgScale, 29*imgScale, 12*imgScale, 4*imgScale), 
				x + 740 - GameState.player.x + 10*sizeScale - 10*sizeScale, y+300 - GameState.player.y + 11*sizeScale,12*sizeScale,4*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(14*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x + 10*sizeScale-(TotalIndex -(Index)), y+300 - GameState.player.y + 11*sizeScale,4*sizeScale,12*sizeScale, null);				
			}
			
			g.drawImage(Image.getSubimage(14*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 
			x + 740 - GameState.player.x+8*sizeScale -(TotalIndex-(Index)), 29*sizeScale+y+300 - GameState.player.y,4*sizeScale,11*sizeScale , null);
			g.drawImage(Image.getSubimage(14*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 
			x + 740 - GameState.player.x+9*sizeScale - (Index), 29*sizeScale+y+300 - GameState.player.y,4*sizeScale,11*sizeScale , null);
		}
		
		
		if(direction == 4) {
			g.drawImage(Image.getSubimage(0*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 
			x + 740 - GameState.player.x+4*sizeScale, 29*sizeScale+y+300 - GameState.player.y,4*sizeScale,11*sizeScale, null);
			g.drawImage(Image.getSubimage(0*imgScale, 12*imgScale, 4*imgScale, 11*imgScale), 
			x + 740 - GameState.player.x+10*sizeScale, 29*sizeScale+y+300 - GameState.player.y,4*sizeScale,11*sizeScale , null);

			g.drawImage(Image.getSubimage(4*imgScale, 0*imgScale, 10*imgScale, 29*imgScale), 
			x + 4*sizeScale+740 - GameState.player.x, y+300 - GameState.player.y,10*sizeScale,29*sizeScale, null);
			
			if(punching2) {
				g.drawImage(Image.getSubimage(0*imgScale, 29*imgScale, 4*imgScale, 6*imgScale), 
				x + 740 - GameState.player.x, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,6*sizeScale, null);
			}
			else {
				g.drawImage(Image.getSubimage(0*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,12*sizeScale, null);				
			}
			if(punching) {
				g.drawImage(Image.getSubimage(0*imgScale, 29*imgScale, 4*imgScale, 6*imgScale), 
				x + 740 - GameState.player.x+14*sizeScale, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,6*sizeScale, null);

			}else {
				g.drawImage(Image.getSubimage(0*imgScale, 0*imgScale, 4*imgScale, 12*imgScale), 
				x + 740 - GameState.player.x+14*sizeScale, 11*sizeScale+y+300 - GameState.player.y,4*sizeScale,12*sizeScale, null);
				
			}			
		}
		
		
		
		Index += IndexInc  ;
		if(Index >= 10* Math.floorDiv(sizeScale, 3)) {
			IndexInc = -1 * IndexInc;
		}
		if(Index <= 0){
			IndexInc = -1 *IndexInc;
		}
		
		if(Index2 != 0) {
			Index2--;
			if(Index2 == 2) {
				punching = false;
				punching2 = false;
			}
		}
	}
	
	public void hurt(int d) {
		if(HurtCooldown <= 0) {
			HurtCooldown = 10;
			this.health -= Math.ceil(d * (100-this.defence)/100f);
			if(health < 0 ) {
				this.die();
			}
			else {
				float thealth = this.thealth + 1;
				new Text("-" + d, this.x + this.width/2 ,this.y + this.height/2,new Color(
						Math.round( 255*((10 -health)/thealth)),
						Math.round( 255*(health/thealth)),
						0), Game.font);	
			}
		}
	}
	
	public void attackF(int mx, int my ) {
		GameState.dungeon.floors.get(z).Entities.forEach(ent ->{
			Rectangle r1 = new Rectangle(mx,my,1,1);
			Rectangle r2 = new Rectangle(ent.x+ 740 - GameState.player.x,ent.y+300 - GameState.player.y ,ent.width,ent.height);
			if(r1.intersects(r2)) {
				ent.hurt(this.attack);
			}
		});
	}
	
	public void die() {
		alive = false;
	}
	
	public void allocateRoom() {
		GameState.dungeon.floors.get(z).Entities.add(this);
		IndexInc = speedy;
		TotalIndex = 10* Math.floorDiv(sizeScale, 3);
	}
	
	public void path() {
		if(Math.abs(this.x - GameState.player.x) < 1920 && Math.abs(this.y - GameState.player.y) < 780) {
			boolean A = false;
			boolean B = false;
			if(Math.abs(this.x - GameState.player.x) > 70 ) {
				this.dir[(int) (1 + Math.signum(this.x - GameState.player.x)+1)] = true;
				this.dir[(int) (1 + Math.signum(-this.x + GameState.player.x)+1)] = false;	
			}
			else {
				this.dir[(int) (1 + Math.signum(this.x - GameState.player.x)+1)] = false;
				this.dir[(int) (1 + Math.signum(-this.x + GameState.player.x)+1)] = false;	
		
				A = true;
			}
			if(Math.abs(this.y - GameState.player.y) > 70 ) {
				this.dir[(int) (Math.signum(-this.y + GameState.player.y)+1)] = true;
				this.dir[(int) (Math.signum(this.y - GameState.player.y)+1)] = false;				
			}
			else {
				this.dir[(int) (Math.signum(-this.y + GameState.player.y)+1)] = false;
				this.dir[(int) (Math.signum(this.y - GameState.player.y)+1)] = false;				

				B = true;
			}
			if(A&&B) {
				GameState.player.hurt(this.attack);
			}
		}
	}
	
	public void move(){
		if(dir[0]) {
			direction =0;
			this.y -= this.speedy;
		}
		if(dir[1]) {
			direction =1;
			this.x += this.speedx;
		}
		if(dir[2]) {
			direction =2;
			this.y += this.speedy;
		}
		if(dir[3]) {
			direction =3;
			this.x -= this.speedx;
		}
		
		if(!(dir[0] || dir[1] || dir[2] || dir[3])) {
			direction = 4;
		}
		
		GameState.dungeon.floors.get(z).Rooms.forEach(r ->{
			Rectangle r1= new Rectangle(x,y,width,height);
			Rectangle r2= new Rectangle(r.x,r.y,r.width,r.height);
			if(r1.intersects(r2)) {
				r.Objects.forEach(b ->{
					if(new Rectangle(x,y,width,height).intersects(b.hitBox)) {
						if(dir[0]) {
							this.y += this.speedy;
						}
						if(dir[1]) {
							this.x -= this.speedx;
						}
						if(dir[2]) {
							this.y -= this.speedy;
						}
						if(dir[3]) {
							this.x += this.speedx;
						}
					}
				});
			}
		});
	}
}
