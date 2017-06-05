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
        System.out.println("Broke");
		getWorld().score.incrementObjectsBroken(value);
		getWorld().removeActor(this);
	}

    public void display() {
       fill(255);
       ellipse(position.x, position.y, radius, radius);
    }
}