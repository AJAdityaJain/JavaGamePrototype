package dev.code.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dev.code.game.States.GameState;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	private boolean click;
	
	public KeyManager() {
		keys = new boolean[256];
		click = false;
	}
	
	public void keyTyped(KeyEvent e) {

	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;	
		if(click==false) {
			if(Game.CurrentState instanceof GameState) {
				if(keys[KeyEvent.VK_E]) {
					GameState.player.inv = !GameState.player.inv;				
				}
				else {
					GameState.player.inv = false;
				}
			}
		}
//		Gson gson = new GsonBuilder()
//		        .registerTypeHierarchyAdapter(RenderedImage.class, RenderedImageTypeAdapter.getRenderedImageTypeAdapter())
//		        .create();
//		String st = gson.toJson(new Zombie(0,0,0));
//		System.out.println(st);
		
		

		click = true;	
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		click = false;
	}
	
	public boolean[] getKeys() {
		return keys;
	}

}
//package dev.code.game;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//public class KeyManager implements KeyListener {
//	
//	public boolean[] keys;
//	private boolean[] justPressed;
//	private boolean[] cantPress;
//	public boolean up, down, left, right;
//	public boolean aUp, aDown, aLeft, aRight;
//	
//	public KeyManager(){
//		keys = new boolean[256];
//		justPressed = new boolean[keys.length];
//		cantPress = new boolean[keys.length];
//	}
//	
//	public void tick(){
//		for(int i = 0;i < keys.length;i++){
//			if(cantPress[i] && !keys[i]){
//				cantPress[i] = false;
//			}else if(justPressed[i]){
//				cantPress[i] = true;
//				justPressed[i] = false;
//			}
//			if(!cantPress[i] && keys[i]){
//				justPressed[i] = true;
//			}
//		}
//		
//		up = keys[KeyEvent.VK_W];
//		down = keys[KeyEvent.VK_S];
//		left = keys[KeyEvent.VK_A];
//		right = keys[KeyEvent.VK_D];
//		
//		aUp = keys[KeyEvent.VK_UP];
//		aDown = keys[KeyEvent.VK_DOWN];
//		aLeft = keys[KeyEvent.VK_LEFT];
//		aRight = keys[KeyEvent.VK_RIGHT];
//	}
//	
//	public boolean keyJustPressed(int keyCode){
//		if(keyCode < 0 || keyCode >= keys.length)
//			return false;
//		return justPressed[keyCode];
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		System.out.println(33);
//		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
//			return;
//		keys[e.getKeyCode()] = true;
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
//			return;
//		keys[e.getKeyCode()] = false;
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {
//		
//	}
//
//}
