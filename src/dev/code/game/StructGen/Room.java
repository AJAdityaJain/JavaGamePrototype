package dev.code.game.StructGen;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import dev.code.game.objects.BlockObjects;
import dev.code.game.objects.AllObjects.Stalag;
import dev.code.game.objects.AllObjects.Walls;

public class Room {
	public int x ;
	public int y ;
	public int z ;
	public int width ;
	public int height ;
	public ArrayList<BlockObjects> Objects = new ArrayList<BlockObjects>();
	
	public Room(int x, int y , int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = 1600;
		this.height = 800;
	}
	
	public void create() {
		new Stalag(x+360,y+130,z,2,5);	

		new Walls(240,240,z);
		new Walls(80,240,z);
		new Walls(160,240,z);
		new Walls(240,80,z);
		new Walls(80,80,z);
		new Walls(160,80,z);
		new Walls(240,160,z);
		new Walls(80,160,z);
		new Walls(160,160,z);
		
		new Walls(400,480,0);
		new Walls(480,400,0);
		new Walls(400,400,0);
		new Walls(320,400,0);
		new Walls(400,320,0);
		
		Room.wallSmoothening(this);
	}
	
	public static void wallSmoothening(Room r) {
		ArrayList<BlockObjects> Objects = r.Objects;
		Objects.forEach(el ->{
			boolean[] cases = new boolean[] {false,false,false,false,false,false,false,false,false};
			Objects.forEach(el2 ->{
				if(el2.boundingBox.x+80 == el.boundingBox.x&&el2.boundingBox.y+80 == el.boundingBox.y) {
					cases[0] = true;
				}
				if(el2.boundingBox.x == el.boundingBox.x&&el2.boundingBox.y+80 == el.boundingBox.y) {
					cases[1] = true;
				}
				if(el2.boundingBox.x-80 == el.boundingBox.x&&el2.boundingBox.y+80 == el.boundingBox.y) {
					cases[2] = true;
				}
				if(el2.boundingBox.x+80 == el.boundingBox.x&&el2.boundingBox.y == el.boundingBox.y) {
					cases[3] = true;
				}
				if(el2.boundingBox.x == el.boundingBox.x&&el2.boundingBox.y == el.boundingBox.y) {
					cases[4] = true;
				}
				if(el2.boundingBox.x-80 == el.boundingBox.x&&el2.boundingBox.y == el.boundingBox.y) {
					cases[5] = true;
				}
				if(el2.boundingBox.x+80 == el.boundingBox.x&&el2.boundingBox.y-80 == el.boundingBox.y) {
					cases[6] = true;
				}
				if(el2.boundingBox.x == el.boundingBox.x&&el2.boundingBox.y-80 == el.boundingBox.y) {
					cases[7] = true;
				}
				if(el2.boundingBox.x-80 == el.boundingBox.x&&el2.boundingBox.y-80 == el.boundingBox.y) {
					cases[8] = true;
				}
			});
			
			if(el.boundingBox.y == r.y) {
				cases[0] = true;
				cases[1] = true;
				cases[2] = true;
			}
			if(el.boundingBox.x == r.x) {
				cases[0] = true;
				cases[3] = true;
				cases[6] = true;
			}
			if(el.boundingBox.x + el.boundingBox.width == r.x+r.width) {
				cases[2] = true;
				cases[5] = true;
				cases[8] = true;
			}
			if(el.boundingBox.y + el.boundingBox.height == r.y+r.height) {
				cases[6] = true;
				cases[7] = true;
				cases[8] = true;
			}
			
			
			
			if(!cases[1]&& !cases[3]&&cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(0, 0, 32, 32);
			}
			if(!cases[1] && cases[3] &&cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(32, 0, 32, 32);
			}
			if(cases[1] && !cases[3] &&cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(0,32, 32, 32);
			}
			if(cases[1] && !cases[3] &&cases[5] && !cases[7]) {
				el.Image = el.OImage.getSubimage(0,64, 32, 64);
			}
			if(cases[1] && cases[3] &&cases[5] && !cases[7]) {
				el.Image = el.OImage.getSubimage(32,64, 32, 64);
			}
			if(cases[1] && cases[3] &&!cases[5] && !cases[7]) {
				el.Image = el.OImage.getSubimage(64,64, 32, 64);
			}
			if(cases[1] && cases[3] &&!cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(64,32, 32, 32);
			}
			if(!cases[1] && cases[3] &&!cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(64,0, 32, 32);
			}
			
			if(!cases[1] && cases[3] && !cases[5] && !cases[7]) {
				BufferedImage combined = new BufferedImage(32, 64, BufferedImage.TYPE_INT_ARGB);

				// paint both images, preserving the alpha channels
				Graphics g = combined.getGraphics();
				g.drawImage(el.OImage.getSubimage(96,32, 32, 32), 0, 0, null);
				g.drawImage(el.OImage.getSubimage(96,96, 32, 32), 0, 32, null);

				g.dispose();
				el.Image = combined;				
			}
			if(!cases[1] && !cases[3] && cases[5] && !cases[7]) {
				BufferedImage combined = new BufferedImage(32, 64, BufferedImage.TYPE_INT_ARGB);

				// paint both images, preserving the alpha channels
				Graphics g = combined.getGraphics();
				g.drawImage(el.OImage.getSubimage(96,0, 32, 32), 0, 0, null);
				g.drawImage(el.OImage.getSubimage(96,96, 32, 32), 0, 32, null);

				g.dispose();
				el.Image = combined;	
			}
			if(!cases[1] && cases[3] && cases[5] && !cases[7]) {
				el.Image = el.OImage.getSubimage(96,64, 32, 64);				
			}
			
			if(cases[1] && !cases[3] && !cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(128,32, 32, 32);				
			}
			if(!cases[1] && !cases[3] && !cases[5] && cases[7]) {
				el.Image = el.OImage.getSubimage(128,0, 32, 32);				
			}
			if(cases[1] && !cases[3] && !cases[5] && !cases[7]) {
				el.Image = el.OImage.getSubimage(128,64, 32, 64);				
			}
		
			
			if(cases[1] && cases[3] &&cases[5] && cases[7] && !cases[6]) {
				System.out.println(23322);
				el.Image = el.OImage.getSubimage(32,32, 32, 32);
			}
			if(cases[1] && cases[3] &&cases[5] && cases[7] && !cases[8]) {
				el.Image = el.OImage.getSubimage(32,32, 32, 32);
			}
			if(cases[1] && cases[3] &&cases[5] && cases[7] && !cases[0]) {
				System.out.println(23322);
				el.Image = el.OImage.getSubimage(32,32, 32, 32);
			}
			if(cases[1] && cases[3] &&cases[5] && cases[7] && !cases[2]) {
				el.Image = el.OImage.getSubimage(32,32, 32, 32);
			}
			
			if(cases[1] && cases[2] && cases[3] && cases[4] && cases[5] && cases[6] && cases[7] && cases[8] ) {
				System.out.println(23322);
				el.Image = el.OImage.getSubimage(32,32, 32, 32);				
			}
		});	
	}
}
