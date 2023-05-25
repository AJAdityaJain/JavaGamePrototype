package dev.code.game.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dev.code.game.States.GameState;


public class BlockObjects {
	public int width,height, length;
	public Rectangle boundingBox;
	public Rectangle hitBox;
	public BufferedImage Image;
	public int t;
	public BufferedImage OImage;
	
	public BlockObjects() {
		
	}
	
	public void allocateRoom(int x, int y, int y2, int z) {
		boundingBox = new Rectangle(x,y,width,height);
		hitBox = new Rectangle(x,y2,width,length);
		GameState.dungeon.floors.get(z).Rooms.forEach(r ->{
			Rectangle r2= new Rectangle(r.x,r.y,r.width,r.height);
			if(hitBox.intersects(r2)) {
				r.Objects.add(this);
			}
		});

	}

	public void render(Graphics g) {
		g.drawImage(Image, hitBox.x+740 - GameState.player.x, hitBox.y+300 - GameState.player.y,width,height,null);
		// TODO Auto-generated method stub
		
	}
}