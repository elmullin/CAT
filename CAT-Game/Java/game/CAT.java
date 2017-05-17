package game;

import processing.core.*;

public class CAT extends PApplet{

	private Background bg;
	
	public void settings(){
	    size(800, 600);
	}
	
	public void setup(){
	    //scene setup
	    surface.setResizable(false);
	    bg = new Background("bg.png");
	}
	
	public void draw(){
	    bg.display();
	}
}