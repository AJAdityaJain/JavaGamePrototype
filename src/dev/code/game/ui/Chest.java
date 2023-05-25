package dev.code.game.ui;

public class Chest extends Button {
	public Chest(int x, int y, int width, int height, boolean l) {
		super(x, y, width, height, 10,null);
		Inventory = new Inventory(l);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
}
