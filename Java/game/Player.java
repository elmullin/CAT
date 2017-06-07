package game;

import processing.core.*; 

public class Player extends Actor {
	/*
	 * Constants
	 */
	private static final int MOVE_RATE = 2;
	private static final char UP = 'w';
	private static final char LEFT = 'a';
	private static final char DOWN = 's';
	private static final char RIGHT = 'd';

	/*
	 * Fields
	 */
	private int[] keysPressed;
	
	PVector mouseVector;

	/**
	 * Constructor. Creates a new object at the given location.
	 */
	public Player(PImage sprite, int posX, int posY, PApplet p) {
		super(sprite, posX, posY, 32, true, p);
		mouseVector = new PVector(0, 0);
		keysPressed = new int[4]; // holds pressed or not pressed state of W, A, S, D, respectively
		parent = p;
	}

	// -------------------------------------------------------------------------
	/*
	 * Overwrite default keyPressed() and keyReleased() to calculate new velocity vector
	 * Called whenever a key is pressed or released, respectively
	 */
	public int[] pressKey(char key) {
		if (UP == key) {
			keysPressed[0] = -1 * MOVE_RATE;
		}
		else if (LEFT == key) {
			keysPressed[1] = -1 * MOVE_RATE;
		}
		if (DOWN == key) {
			keysPressed[2] = MOVE_RATE;
		}
		if (RIGHT == key) {
			keysPressed[3] = MOVE_RATE;
		}
		return keysPressed;
	}

	public int[] releaseKey(char key) {
		if (UP == key) {
			keysPressed[0] = 0;
		}
		else if (LEFT == key) {
			keysPressed[1] = 0;
		}
		if (DOWN == key) {
			keysPressed[2] = 0;
		}
		if (RIGHT == key) {
			keysPressed[3] = 0;
		}
		return keysPressed;
	}

	// -------------------------------------------------------------------------
	
	@Override
	public void move(){
		getVelocity().set(keysPressed[3] + keysPressed[1], keysPressed[2] + keysPressed[0]);
		super.move();
	}
	
	@Override
	public boolean display() {
		move();
		
		parent.translate(getPosition().x, getPosition().y);
		mouseVector.set(parent.mouseX, parent.mouseY);
		mouseVector.sub(getPosition());
		parent.rotate(mouseVector.heading());

		parent.image(sprite, 0, 0);
		parent.resetMatrix();

		return false;
	}

	//override collide for breakable object BROKEN?
	@Override
	public void extraEffect(PhysObject obj) {
		if (obj instanceof BreakableObject) {
			((BreakableObject)obj).breakObject();
		}
	}
}