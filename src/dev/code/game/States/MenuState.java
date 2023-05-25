package dev.code.game.States;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.code.game.Game;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.save.Saver;
import dev.code.game.ui.Button;
import dev.code.game.ui.UIObject;

public class MenuState extends State {
	public MenuState() {
		super();
		UIObjects = new ArrayList<UIObject>();
		UIObjects.add(new Button(660,100,200,100,1,null));
		UIObjects.add(new Button(660,200,200,100,2,null));
		UIObjects.add(new Button(660,300,200,100,3,null));
		UIObjects.add(new Button(660,300,200,100,3,null));
		UIObjects.add(new Button(660,410,100,100,4,null));
		UIObjects.add(new Button(760,410,100,100,5,null));
//		UIObjects.add(new ArrayList<UIObject>());
//		UIObjects.get(1).add(new Button(660,410,100,100,"b7", new Deal(new BroadSword(), 1, new BroadSword(), 8)));
	}
	
	public void tick(){

	}
	
	public void render(Graphics g) {
		UIObjects.forEach(b ->{
			if(b.pressed == 0) {
				b.image = ImgAssets.b[b.src-1];				
			}
			else {
				b.pressed -= b.speed;							
				if(b.pressed == 0) {
					if(b.src == 1) {
						Game.CurrentState = new GameState(1000); 
					}
					if(b.src == 2) {

					}
					if(b.src== 3) {
						Game.CurrentState = Game.StorageState;
					}
					if(b.src == 5) {
						Saver.SaveProggress();
						System.exit(1);
					}
					if(b.src == 7){
					}

				}
			}
			b.render(g,0,0);
		});
	}
}