package dev.code.game.items.AllItems;

import dev.code.game.gfx.ImgAssets;
import dev.code.game.items.Items;

public class BroadSword extends Items {
	public BroadSword() {
		super();
		image = ImgAssets.BroadSword;
		stackAmount = 3;
		info = "The most basic sword used by the newbie player. Not that good but definitely the baseline";
	}
}