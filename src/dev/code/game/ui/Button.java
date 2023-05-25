package dev.code.game.ui;

import dev.code.game.economy.Deal;
import dev.code.game.gfx.ImgAssets;

public class Button extends UIObject {
	public boolean on;
	public Button(int x,int y,int width,int height,int src, Deal deal) {
		super(x,y,width,height,src);
		pressed = 0;
		speed = 1;
		
		this.deal = deal;
	}
	
	public void press() {
		if(pressed == 0) {
			this.image = ImgAssets.bp[src-1];
			pressed = 10;	
		}			
	}
}