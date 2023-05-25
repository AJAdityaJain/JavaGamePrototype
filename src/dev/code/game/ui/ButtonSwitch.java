package dev.code.game.ui;

import dev.code.game.gfx.ImgAssets;
import dev.code.game.save.Saver;

public class ButtonSwitch extends Button {

	public ButtonSwitch(int x, int y, int width, int height) {
		super(x, y, width, height, 6,null);
//		pressed = 1;
		speed = 0;
		this.on = false;
	}
	

	public void press() {
		pressed = 1;
		Saver.SaveProggress();
		on = !on;
		if(on) {
			this.image = ImgAssets.b[src-1];			
		}
		else {
			this.image = ImgAssets.bp[src-1];
		}
	}
}
