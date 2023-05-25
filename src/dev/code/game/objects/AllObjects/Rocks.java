package dev.code.game.objects.AllObjects;

import dev.code.game.gfx.ImgAssets;
import dev.code.game.objects.BlockObjects;

public class Rocks extends BlockObjects{

	public Rocks(int x, int y, int z,int t,int s) {
		super();
		width = 32*s;
		height = 24*s;
		length = 24*s;//100 -> player hieght;
		Image = ImgAssets.rocks.getSubimage(0, t*24, 32, 24);
		allocateRoom(x,y,y,z);
	}
}
