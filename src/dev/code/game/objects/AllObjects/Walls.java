package dev.code.game.objects.AllObjects;

import dev.code.game.gfx.ImgAssets;
import dev.code.game.objects.BlockObjects;

public class Walls extends BlockObjects{
	public Walls(int x, int y, int z) {
		super();
		width = 80;
		height = 80;
		length = 50;//100 -> player hieght;
		t = 2;
		Image = ImgAssets.wall1;
		OImage = Image;
		allocateRoom(x,y,y,z);
	}
}
