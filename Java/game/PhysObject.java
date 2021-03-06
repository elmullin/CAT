package game;

import processing.core.*;

public abstract class PhysObject{
	
	private PVector position;
	
	// A vector describing the object's movement
	private PVector velocity;
	
	// the collision radius
	float radius;
	
	// world actor belongs to
	private World world;
	
	boolean moveable;
	
	// PApplet reference
	PApplet parent;
	
	
	/* CONSTRUCTORS */
	
	/**
	 * Full constructor.
	 */
	public PhysObject(float posX, float posY, float velX, float velY, 
	float collisionRadius, boolean isMoveable, PApplet p){
		radius = collisionRadius;
		moveable = isMoveable;
		position = new PVector(posX, posY);
		velocity = new PVector(velX, velY);
		parent = p;
	}
	
	/**
	 * No-velocity constructor.
	 */
	public PhysObject(float posX, float posY, float collisionRadius, boolean isMoveable, PApplet p){
		this(posX, posY, 0, 0, collisionRadius, isMoveable, p);
	}
	
	/* MOVEMENT */
	
	/**
	 * Moves the object in the direction of the velocity and checks for collisions.
	 */
	public void move(){
		if(velocity.mag() != 0){
			position.add(velocity);
			
			for(Actor a : getWorld().getActors(TabbyCat.class)){
				collide(a);
			}
			for (Actor a : getWorld().getActors(BreakableObject.class)) {
				collide((BreakableObject)a);
			}
			for(Wall w : getWorld().getWalls()){
				collide(w);
			}
		}
	}
	
	/**
	 * Adjusts the speed at which the object moves by a relative amount.
	 * Returns the final speed.
	 */
	public float addSpeed(float amt){
		float newVel = velocity.mag() + amt;
		velocity.setMag(newVel);
		return newVel;
	}
	
	/**
	 * Sets the angle at which the object moves.
	 * Returns the final speed.
	 */
	public float setSpeed(float amt){
		velocity.setMag(amt);
		return amt;
	}
	
	/**
	 * Adjusts the angle at which the object moves by a relative amount.
	 * Returns the final angle.
	 */
	public float addAngle(float amt){
		velocity.rotate(amt);
		return velocity.heading();
	}
	
	/**
	 * Sets the angle at which the object moves.
	 * Returns the final angle.
	 */
	public float setAngle(float amt){
		velocity.rotate((-1 * velocity.heading()) + amt);
		return amt;
	}
	
	/* COLLISIONS */
	
	/**
	 * Empty method -- override to add additional effects on collide.
	 */
	public void extraEffect(PhysObject obj){}
	
	/**
	 * Checks whether this collides with the given PhysObject.
	 * If it does, bumps it to the closest open spot.
	 */
	public void collide(PhysObject obj){
		float distance = position.dist(obj.position);
		float boundary = radius + obj.radius;
		
		if (distance < boundary && obj != this) {
			if(obj.moveable){
				PVector adjust = PVector.sub(position, obj.position).normalize().mult((float)((boundary - distance) / 2.0));
				position.add(adjust);
				obj.position.sub(adjust);
			}
			else {
				position.add(PVector.sub(position, obj.position).normalize().mult(boundary - distance));
			}
			extraEffect(obj);
		}
	}
	
	/* collsion for a wall and a round object
	 * note: this could probably be optimized
	 */
	public void collide(Wall wall){

		float myTop = position.y - radius;
		float myRight = position.x + radius;
		float myBottom = position.y + radius;
		float myLeft = position.x - radius;
		
		// negative is a collision; positive is null
		float top = PApplet.min(myTop - wall.bottom, 0);
		float left = PApplet.min(myLeft - wall.right, 0);

		// positive is a collision; negative is null
		float right = PApplet.max(myRight - wall.left, 0);
		float bottom = PApplet.max(myBottom - wall.top, 0);
		
		if (Float.compare(top, 0) != 0
		 && Float.compare(left, 0) != 0
		 && Float.compare(right, 0) != 0
		 && Float.compare(bottom, 0) != 0){
			float y = (PApplet.abs(top) < PApplet.abs(bottom)) ? top : bottom;
			float x = (PApplet.abs(left) < PApplet.abs(right)) ? left : right;
			if (PApplet.abs(x) < PApplet.abs(y)){
				position.x -= x;
			}
			else {
				position.y -= y;
			}
		}
	}
	
	/**
	 * Checks whether this collides with the given PhysObject
	 */
	public boolean isIntersecting(PhysObject obj){
		float distance = position.dist(obj.position);
		float boundary = radius + obj.radius;
		
		return distance < boundary;
	}
	
	/**
	 * Checks whether this collides with the given Wall
	 */
	public boolean isIntersecting(Wall wall){
		
		float myTop = position.y - radius;
		float myRight = position.x + radius;
		float myBottom = position.y + radius;
		float myLeft = position.x - radius;
		
		return (myLeft < wall.right)
				&& (wall.left < myRight)
				&& (myTop < wall.bottom)
				&& (wall.top < myBottom);
	}
	
	// returns world of this actors as a World
	public World getWorld() {
		return this.world;
	}
	
	// sets the world this actor is in
	public void setWorld(World world) {
		this.world = world;
	}
	
	// position and velocity getters and setters
	public PVector getPosition() {
		return position;
	}
	
	public void setPosition(PVector position) {
		this.position = position;
	}
	
	public PVector getVelocity() {
		return velocity;
	}
	
	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}
}