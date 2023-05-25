package dev.code.game.objects.AllObjects;

import dev.code.game.gfx.ImgAssets;
import dev.code.game.objects.BlockObjects;

public class Altar extends BlockObjects{

	public Altar(int x, int y, int z) {
		super();
		width = 75;
		height = 96;
		length = 32;//100 -> player hieght;
		Image = ImgAssets.Altar;
		allocateRoom(x,y,y,z);
	}
}
