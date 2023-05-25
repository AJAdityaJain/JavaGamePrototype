package dev.code.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.code.game.States.MenuState;
import dev.code.game.States.State;
import dev.code.game.States.StorageState;
import dev.code.game.display.Display;
import dev.code.game.gfx.FontLoader;
import dev.code.game.gfx.ImgAssets;
import dev.code.game.save.Saver;

public class Game implements Runnable {
	public Display display;
	public String title;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	public int width,height;
	private boolean running = false;
	public static State CurrentState;
	public static KeyManager keyManager;
	public static MouseManager mouseManager;
	public static Font font = FontLoader.loadFont("res/fonts/1.otf", 40);
	public static StorageState StorageState;
	public static MenuState MenuState;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}	
	
	public synchronized void start() {
		if(this.running == false) {
			this.running = true;
			this.thread = new Thread(this);
			this.thread.start();	
		}
	}
	
	private void init() {

		this.display = new Display(title, width,height);
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		ImgAssets.init();
		StorageState = new StorageState();
		MenuState = new MenuState();
		CurrentState = MenuState;
		try {
			Saver.readProgress("inventory");
		}
		catch(Exception e) {
			System.out.println(Saver.encrypt("[[\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"BroadSword#4\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\"],[\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"LongSword#1\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\",\"Void#0\"]]", 4));
		}
	}
	
	private void tick() {
		CurrentState.tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);//3;
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//Actrend
		CurrentState.render(g);
		
		bs.show();
		g.dispose();
	}

	public void run() {
		this.init();
		
		int fps = 20;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		while (running) {
			now = System.nanoTime();
			delta += (now-lastTime) / timePerTick;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();	
				delta--;
			}
		}
		
		this.stop();
	}
	
	public synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			System.out.println("Bop");
			e.printStackTrace();
		}
	}
}
