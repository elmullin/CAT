package game;

import processing.core.*;

public class Background{
	private PImage bg;
		
	public Background(PImage bg){
		this.bg = bg;
	}
		
	public void display(){
		background(bg);
	}
}