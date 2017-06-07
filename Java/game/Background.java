package game;

import processing.core.*;

public class Background{
	private PImage bg;
	PApplet parent;
		
	public Background(PImage bg, PApplet p){
		this.bg = bg;
		parent = p;
	}
		
	public void display(){
		parent.background(bg);
	}
}