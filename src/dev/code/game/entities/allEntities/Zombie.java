package dev.code.game.entities.allEntities;

import dev.code.game.entities.Entities;
import dev.code.game.gfx.ImgAssets;

public class Zombie extends Entities{
	public Zombie(int x, int y, int z){
		super(x,y,z);
		Image = ImgAssets.zombie;
		width = 54;
		height = 120;
		health = 10;
		thealth = 9;
		speedx = 2;
		speedy = 1;
		attack = 1;
		punching = true;
		punching2 = true;
		allocateRoom();
		
	}
}
