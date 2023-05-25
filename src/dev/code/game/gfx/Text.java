package dev.code.game.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import dev.code.game.States.GameState;

public class Text {
	public String str;
	public int xPos;
	public int yPos;
	public Color colour;
	public Font Font;
	public int Opacity = 255;
	
	public Text(String str, int xPos, int yPos, Color c, Font font) {
		this.str = str;
		this.xPos = xPos;
		this.yPos = yPos;
		this.colour = c;
		this.Font = font;
		GameState.TextArr.add(this);
	}
	
	
	public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font){
		g.setColor(c);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if(center){
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos - fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}

}
