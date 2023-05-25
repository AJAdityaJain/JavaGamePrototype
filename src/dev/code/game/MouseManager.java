package dev.code.game;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import dev.code.game.States.GameState;
import dev.code.game.States.StorageState;
import dev.code.game.StructGen.Room;
import dev.code.game.objects.AllObjects.Walls;

public class MouseManager implements MouseListener, MouseMotionListener {

	public boolean leftPressed, rightPressed;
	public int mouseX, mouseY;
	
	public MouseManager(){
 
	}
	
	// Implemented methods
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = true;
			if(Game.CurrentState instanceof GameState) {
				if(!GameState.player.punching) {
					GameState.player.punching = true;
//					GameState.player.punching2 = true;
					GameState.player.Index2 = 10;
					GameState.player.attackF(mouseX,mouseY);
					new Walls((mouseX/80)*80,(mouseY/80)*80,0);
				}
			}
			else {
				Game.CurrentState.UIObjects.forEach(b ->{
					Rectangle r1 = new Rectangle(b.x,b.y,b.width,b.height);
					Rectangle r2 = new Rectangle(mouseX,mouseY,1,1);
					if(r1.intersects(r2)) {
						b.press();
					}
				});
				if(Game.CurrentState instanceof StorageState) {
					Rectangle r1 = new Rectangle(1377,32,130,150);
					Rectangle r2 = new Rectangle(mouseX,mouseY,1,1);
					if(r2.intersects(r1)){
						Game.StorageState.SelectedInventory = null;
						System.out.println(Game.StorageState.SelectedInventory);
					}					
				}
			}
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			rightPressed = true;
			Room.wallSmoothening(GameState.dungeon.floors.get(0).Rooms.get(0));
		}			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			leftPressed = false;
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
