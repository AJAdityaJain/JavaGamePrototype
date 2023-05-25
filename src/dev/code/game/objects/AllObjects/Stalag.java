package dev.code.game.objects.AllObjects;

import java.awt.Graphics;

import dev.code.game.States.GameState;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.objects.BlockObjects;

public class Stalag extends BlockObjects{
	public int s = 5;
	public int mm = (int) Math.floor(Math.random()*10);
	public int sm = (int) Math.floor(Math.random()*10)+mm;
	public Stalag(int x, int y, int z,int t, int s) {
		super();
		this.t = t;
		this.s = s;
		y += (sm*s);
		width = 8*s;
		height = (51*s) - (sm*s) ;//- ((16-mm)*s) - ((15-sm)*s);
		length = height-100;//100 -> player hieght;
		Image = ImgAssets.Stalags;
		allocateRoom(x,y,y,z);
	}


	public void render(Graphics g) {
		g.drawImage(Image.getSubimage(12, t*20, 2, 17),
				boundingBox.x+740 - GameState.player.x + (3*s),
				boundingBox.y+300 - GameState.player.y ,
				(2)*s,(17)*s,null);
		
		g.drawImage(Image.getSubimage(8, t*20, 4 ,18),
				boundingBox.x+740 - GameState.player.x + (2*s), 
				boundingBox.y+300 - GameState.player.y + (16*s) + (mm*s) -  (sm*s),
				4*s,18*s,null);

		
		g.drawImage(Image.getSubimage(0, t*20, 8, 20),
				boundingBox.x+740 - GameState.player.x,
				boundingBox.y+300 - GameState.player.y + (31*s)-(sm*s),
				8*s,20*s,null);
	}
}
