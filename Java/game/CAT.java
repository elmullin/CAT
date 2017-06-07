package game;

import processing.core.*;
import ddf.minim.*;

public class CAT extends PApplet{
	
	private World world;
	private Minim minim;

	PImage catImg;
	PImage bgImg;
	PImage playerImg;
	PImage scoreZoneImg;

	Player player;
	
	public static void main(String[] args){
		PApplet.main("CAT");
	}

	public void setup(){
		minim = new Minim(this);
		LevelBuilder levelBuilder = new LevelBuilder();
		
		// load images
		bgImg = loadImage("/assets/bg.gif");
		catImg = loadImage("/assets/cat.gif");
		playerImg = loadImage("/assets/player.gif");
		scoreZoneImg = loadImage("/assets/scorezone.png");
		
		world = levelBuilder.buildWorld(minim, bgImg, playerImg, catImg, scoreZoneImg, this);
		player = (Player)(world.getActors(Player.class).get(0));
	}
	
	public void draw(){
		imageMode(CENTER);
		world.display();
	}
	
	public void settings(){
		size(800, 600);
	}
	
	public void keyPressed() {
		player.pressKey(key);
	}
	
	public void keyReleased() {
		player.releaseKey(key);
	}
	
	public void mousePressed() {
	    if (world.getButton().overRect()) {
	        world.getButton().pressMouse();
	    }
	}
}