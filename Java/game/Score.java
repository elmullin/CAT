package game;

import processing.core.*;

/*
 * A class that keeps track of the number of objects broken, the amount of time
 * taken in the level, and the number of cats corralled and converts them
 * to dollar values. 
 */
public class Score {
	private static final int CAT_RATE = 100; // amount of money made per cat
	
	private int valObjectsBroken; // the total value of broken objects measured in dollars
	private int objectsBroken; // the number of broken objects
	private int catsCorralled; // the number of cats captured
	
	PApplet parent;

    // ------------------------------------------------------------------------------------

	public Score(PApplet p) {
		valObjectsBroken = 0;
		objectsBroken = 0;
		catsCorralled = 0;
		parent = p;
	}

    // ------------------------------------------------------------------------------------
    
    public void display() {
        parent.pushMatrix();
            parent.fill(255, 128);
            parent.rect(0, 0, 100, 50, 12, 12, 12, 12);
            parent.fill(50);
            if (0 <= getCatValue() + getObjectsValue()) {
                parent.text("$" + (getCatValue() + getObjectsValue()) + ".00", 10, 30);
            }
            else {
                  parent.text("-$" + PApplet.abs(getCatValue() + getObjectsValue()) + ".00", 10, 30);
            }
        parent.popMatrix();
        parent.resetMatrix();
    }
	
	/**
	 * Increase the total value of broken objects by the specified value and
	 * the number of broken objects by 1
	 * 
	 * @param value The value of the object that called incrementObjectsBroken
	 */
	public void incrementObjectsBroken(int value) {
		objectsBroken += 1;
		valObjectsBroken -= value;
	}
	
	/**
	 * Increase the number of cats corralled by 1
	 */
	public void incrementCatsCorralled() {
		catsCorralled += 1;
	}
	
	/**
	 * Returns a positive value representing the dollar value of the number 
	 * of cats captured
	 * 
	 * @return The dollar value of the number of cats captured
	 */
	public int getCatValue() {
		return catsCorralled * CAT_RATE;
	}
	
	/**
	 * Returns a positive value representing the number of cats captured
	 * 
	 * @return The number of cats captured
	 */
	public int getNumCats() {
		return catsCorralled;
	}
	
	/**
	 * Returns a positive integer representing the number of broken objects
	 * 
	 * @return The number of broken objects.
	 */
	public int getNumObjects() {
		return objectsBroken;
	}
	
	/**
	 * Returns a negative integer representing the dollar value of broken objects
	 * 
	 * @return The dollar value of the broken objects
	 */
	public int getObjectsValue() {
		return valObjectsBroken;
	}
}