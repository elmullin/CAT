package game;

import processing.core.*;

public class BreakableObject extends Actor {

	private int value; // the cost of the object
	
	PApplet parent;
	
	public BreakableObject(int value, PImage image, float posX, float posY, float radius, PApplet p) {
		super(image, posX, posY, radius, false, p);
		this.value = value;
		parent = p;
	}

	/*
	* Called by a player or cat if they collide with this object
	*/
	public void breakObject() {
		getWorld().score.incrementObjectsBroken(value);
		markDelete();
	}

	public boolean display() {
		if (deletionMark) {
			return deletionMark;
		}
		parent.fill(255);
		parent.ellipse(position.x, position.y, radius, radius);
        parent.stroke(160);
        parent.fill(0, 0);
        parent.ellipse(position.x, position.y, radius * 3 / 4, radius * 3 / 4);
        parent.noStroke();
        parent.fill(100, 255);
        parent.ellipse(position.x, position.y, radius * 5 / 8, radius * 5 / 8);
		return deletionMark;
	}
}