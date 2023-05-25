package dev.code.game.gfx;

import java.awt.image.BufferedImage;

public class ImgAssets {
	public static BufferedImage mummy,zombie,player,
	Void,BroadSword,
	wall1,wall2,rocks,Stalags,Altar,
	dealBg,inventoryBg,largeInventoryBg,timerBG,pointerAggressive,pointerPassive,pointerPlayer,pointerImportant,StatGui1,StatGui2;
	
	public static BufferedImage b1,b1p,b2,b2p,b3,b3p,b4,b4p,b5,b5p,b6,b6p,b7,b7p,b8,b8p,b9,b9p,b10,b10p;
	
	public static BufferedImage[] b = new BufferedImage[10];
	public static BufferedImage[] bp = new BufferedImage[10];

	public static void init() {
		System.out.println("---------START----------");
		mummy = ImageLoader.loadImage("entities/mummy");
		zombie = ImageLoader.loadImage("entities/zombie");
		player = ImageLoader.loadImage("entities/player");
		Void = ImageLoader.loadImage("items/void");
		BroadSword = ImageLoader.loadImage("items/BroadSword");
		wall1 = ImageLoader.loadImage("objects/walls/wall1");
		wall2 = ImageLoader.loadImage("objects/walls/wall2");
		rocks = ImageLoader.loadImage("objects/rocks");
		Stalags = ImageLoader.loadImage("objects/Stalags");
		Altar = ImageLoader.loadImage("objects/Altar");
		dealBg = ImageLoader.loadImage("ui/dealBG");
		timerBG = ImageLoader.loadImage("ui/timerBG");
		inventoryBg = ImageLoader.loadImage("ui/invBG");
		largeInventoryBg = ImageLoader.loadImage("ui/invlargeBG");
		pointerAggressive = ImageLoader.loadImage("ui/pointerAggressive");
		pointerPassive = ImageLoader.loadImage("ui/pointerPassive");
		pointerPlayer = ImageLoader.loadImage("ui/pointerPlayer");
		pointerImportant = ImageLoader.loadImage("ui/pointerImportant");
		StatGui1 = ImageLoader.loadImage("ui/StatGui1");
		StatGui2 = ImageLoader.loadImage("ui/StatGui2");
		
		b1 = ImageLoader.loadImage("ui/b1");    
		b2 = ImageLoader.loadImage("ui/b2");    
		b3 = ImageLoader.loadImage("ui/b3");    
		b4 = ImageLoader.loadImage("ui/b4");    
		b5 = ImageLoader.loadImage("ui/b5");    
		b6 = ImageLoader.loadImage("ui/b6");    
		b7 = ImageLoader.loadImage("ui/b7");    
		b8 = ImageLoader.loadImage("ui/b8");    
		b9 = ImageLoader.loadImage("ui/b9");    
		b10 = ImageLoader.loadImage("ui/b10");  
		b = new BufferedImage[]{b1,b2,b3,b4,b5,b6,b7,b8,b9,b10};
		
		b1p = ImageLoader.loadImage("ui/b1p");    
		b2p = ImageLoader.loadImage("ui/b2p");    
		b3p = ImageLoader.loadImage("ui/b3p");    
		b4p = ImageLoader.loadImage("ui/b4p");    
		b5p = ImageLoader.loadImage("ui/b5p");    
		b6p = ImageLoader.loadImage("ui/b6p");    
		b7p = ImageLoader.loadImage("ui/b7p");    
		b8p = ImageLoader.loadImage("ui/b8p");    
		b9p = ImageLoader.loadImage("ui/b9p");    
		b10p = ImageLoader.loadImage("ui/b10p");  
		bp = new BufferedImage[]{b1p,b2p,b3p,b4p,b5p,b6p,b7p,b8p,b9p,b10p};
		System.out.println("---------STOP----------");
	}

}
