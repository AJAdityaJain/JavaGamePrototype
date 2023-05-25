package dev.code.game.items.AllItems;

import dev.code.game.gfx.ImageLoader;
import dev.code.game.items.Items;

public class LongSword extends Items {
	public LongSword() {
		super();
		image = ImageLoader.loadImage("/items/LongSword");
		stackAmount = 3;
		info = "The better counterpart of the Broad Sword";
	}
}