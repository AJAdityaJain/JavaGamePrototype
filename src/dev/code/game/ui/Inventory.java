package dev.code.game.ui;

import java.awt.Color;
import java.awt.Graphics;

import dev.code.game.Game;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.gfx.Text;
import dev.code.game.items.Items;
import dev.code.game.items.AllItems.Void;

public class Inventory {
	public Items[] ItemArr = new Items[54];
	public int[] Amount = new int[54];
	public boolean bg = false;
	
	public Inventory(boolean l) {
		if(l == true) {
			bg = true;
		}
		for(int i =0; i < 54; i ++)	 {
			this.ItemArr[i] = new Void();
		}
	}
	
	public void SetItem(Object Inst,int a,int l) {
		ItemArr[l] = (Items) Inst;
		Amount[l] = a;
	}
	
	public void render(Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		if(bg) {
			g.drawImage(ImgAssets.largeInventoryBg,0, 0, 1540, 780,null);
			for(int i =0; i<Amount.length;i++) {
				g.drawRect(300+(i%9)*100,100+ Math.floorDiv(i, 9)*100, 100,100);
				g.drawImage(ItemArr[i].image, 300+(i%9)*100,100+ Math.floorDiv(i, 9)*100, 100,100,null);
				Text.drawString(g,Integer.toString(Amount[i]), 300+(i%9)*100,140+ Math.floorDiv(i, 9)*100, false,Color.white, Game.font);
			}
		}
		else {
			g.drawImage(ImgAssets.inventoryBg,0, 0, 1540, 780,null);
		}
	}
}
