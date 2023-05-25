package dev.code.game.States;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.code.game.gfx.ImgAssets;
import dev.code.game.ui.Inventory;
import dev.code.game.ui.UIObject;

public class StorageState extends State {
	public Inventory SelectedInventory = null;
	public StorageState() {
		super();
		UIObjects = new ArrayList<UIObject>(); 	
	}
	
	public void tick(){

	}
	
	public void render(Graphics g) {
		UIObjects.forEach(b ->{
			if(b.pressed == 0) {

				b.image = ImgAssets.b[b.src-1] ;				
			}
			else {
				b.pressed -= b.speed;							
				if(b.pressed <= 0) {
					if(b.src == 10) {
						SelectedInventory = b.Inventory;
					}
				}
			}
			b.render(g,0,0	);
			if(SelectedInventory != null) {
				SelectedInventory.render(g, 0, 0);
			}
		});
	}
}