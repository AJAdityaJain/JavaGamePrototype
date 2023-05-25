package dev.code.game.gfx;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	public static BufferedImage loadImage(String path) {
		System.out.println(path);
		try {
			return ImageIO.read(new FileInputStream("res/textures/"+path+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(path);
			System.exit(1);
		}
		return null;
		
	}
	
}
