package dev.code.game.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.code.game.Game;
import dev.code.game.economy.Deal;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.gfx.Text;

public abstract class UIObject {
	public int x,y,width,height, pressed, speed;
	public BufferedImage image;
	public int src;
	public Deal deal;
	public Inventory Inventory;

	public UIObject(int x,int y, int width, int height, int src) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.src = src;
		this.image = ImgAssets.b[src-1];
	}

	public abstract void press();
	
	public void render(Graphics g, int i, int yo) {
		if(src==7) {
			g.drawImage(ImgAssets.dealBg, x-10, y-10, (width+10)*4, height+10, null);
			g.drawImage(deal.objInp.image, x+width, y, width, height, null);
			g.drawImage(deal.objOut.image, x+width+width+width, y, width, height, null);
			g.drawImage(image, x, y, width, height, null);
			Text.drawString(g, Integer.toString(deal.numInp), x+width+width, y+height -15, true, Color.LIGHT_GRAY, Game.font);
			Text.drawString(g, Integer.toString(deal.numOut), x+width+width+width+width, y+height -15, true, Color.LIGHT_GRAY, Game.font);
		
		}
		else {
			g.drawImage(image, x, y, width, height, null);				
		}

	}
}
