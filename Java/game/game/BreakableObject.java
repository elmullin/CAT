package game;

import processing.core.*;

public class BreakableObject extends Actor {

	private int value; // the cost of the object
	
	public BreakableObject(int value, PImage image, float posX, float posY, float radius) {
		super(image, posX, posY, radius, false);
		this.value = value;
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
		fill(255);
		ellipse(position.x, position.y, radius, radius);
        stroke(160);
        fill(0, 0);
        ellipse(position.x, position.y, radius * 3 / 4, radius * 3 / 4);
        noStroke();
        fill(100, 255);
        ellipse(position.x, position.y, radius * 5 / 8, radius * 5 / 8);
		return deletionMark;
	}
}