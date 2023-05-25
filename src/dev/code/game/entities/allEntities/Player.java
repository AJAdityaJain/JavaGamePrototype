package dev.code.game.entities.allEntities;

import dev.code.game.entities.Entities;
import dev.code.game.gfx.ImgAssets;

public class Player extends Entities{
	public boolean inv;
	public Player(int x, int y, int z){
		super(x,y,z);
		Image = ImgAssets.player;
		width = 54;
		height = 120;
		health = 10;
		thealth = 9;
		speedx = 20;//20//4
		speedy = 10;//10//2
		attack = 3;
		imgScale = 1;
		defence = 90;
		inv = false;
		sizeScale = 3;
		pointer = ImgAssets.pointerPlayer;
		allocateRoom();
	}
	
	public void path() {}
}