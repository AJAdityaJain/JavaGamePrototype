package dev.code.game.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import dev.code.game.gfx.ImageLoader;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private String title;
	private int width,height;
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		this.createDisplay();
	}
	
	private void createDisplay() {
		this.frame = new JFrame(this.title);
		this.frame.setSize(this.width, this.height);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.frame.setResizable(false);
		this.frame.setIconImage(ImageLoader.loadImage("ui/icon"));
		
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(new Dimension(this.width,this.height));
		this.canvas.setMaximumSize(new Dimension(this.width,this.height));
		this.canvas.setMinimumSize(new Dimension(this.width,this.height));
		this.canvas.setFocusable(false);
		this.canvas.setBackground(new Color(51,51,51));
		this.frame.add(this.canvas);
		this.frame.pack();
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
