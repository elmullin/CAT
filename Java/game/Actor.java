package game;

import processing.core.*;

public class Actor extends PhysObject{
	
	// -- variables --
	
	// sprite of actor
	protected PImage sprite;

	// deletion marker
	protected boolean deletionMark;
	
	// -- constructors --

	// make actor in position with sprite
	public Actor(PImage sprite, float posX, float posY, float radius, boolean moveable, PApplet p) {
		super(posX, posY, 0, 0, radius, moveable, p);
		this.sprite = sprite;
		deletionMark = false;
		parent = p;
	}

	public Actor(PImage sprite, float posX, float posY, PApplet p) {
		this(sprite, posX, posY, 0, false, p);
		deletionMark = false;
		parent = p;
	}
	
	public Actor(PApplet p) {
		super(0, 0, 0, false, p);
		this.parent = p;
		this.deletionMark = false;
	}
	
	// -- methods --
	
	// display actor on screen
	public boolean display() {
		if (sprite != null) {
			parent.image(sprite, getPosition().x, getPosition().y);
		}
		parent.resetMatrix();
		return deletionMark;
	}
	
	// change sprite of actor
	void setImage(PImage sprite) {
		this.sprite = sprite;
	}
	
	// change sprite of actor to given size
	void scaleImage(int x, int y) {
		this.sprite.resize(x, y);
	}
	
	// scale sprite of actor by given factor
	void scaleImage(double factor) {
		scaleImage((int) Math.round(factor * parent.width), (int) Math.round(factor * parent.height));
	}
	
	// removes actor from world
	public void remove() {
		setWorld(null);
		getWorld().removeActor(this);
	}
	
	// returns x-value of actor
	float getX() {
		return getPosition().x;
	}
	
	// returns y-value of actor
	float getY() {
		return getPosition().y;
	}
	
	// returns width of actor
	int getWidth() {
		return parent.width;
	}
	
	// returns height of actor
	int getHeight() {
		return parent.height;
	}
	
	// returns sprite of actor
	public PImage getImage() {
		return sprite; 
	}

	public void markDelete() {
		deletionMark = true;
	}
}