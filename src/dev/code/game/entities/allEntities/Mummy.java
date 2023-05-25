package dev.code.game.entities.allEntities;

import dev.code.game.entities.Entities;
import dev.code.game.gfx.ImgAssets;

public class Mummy extends Entities{
	public Mummy(int x, int y, int z){
		super(x,y,z);
		Image = ImgAssets.mummy;
		width = 54;
		height = 120;
		health = 10;
		thealth = 9;
		speedx = 2;
		speedy = 1;
		attack = 1;
		imgScale = 2;
		punching = true;
		punching2 = true;
		allocateRoom();
		
	}
}
