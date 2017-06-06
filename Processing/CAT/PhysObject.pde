public abstract class PhysObject{
	
	protected PVector position;
	
	// A vector describing the object's movement
	PVector velocity;
	
	// the collision radius
	float radius;
	
	boolean moveable;
	
	
	/* CONSTRUCTORS */
	
	/**
	 * Full constructor.
	 */
	public PhysObject(float posX, float posY, float velX, float velY, 
	float collisionRadius, boolean isMoveable){
		radius = collisionRadius;
		moveable = isMoveable;
		position = new PVector(posX, posY);
		velocity = new PVector(velX, velY);
	}
	
	/**
	 * No-velocity constructor.
	 */
	public PhysObject(float posX, float posY, float collisionRadius, boolean isMoveable){
		this(posX, posY, 0, 0, collisionRadius, isMoveable);
	}
	
	/* MOVEMENT */
	
	/**
	 * Moves the object in the direction of the velocity and checks for collisions.
	 */
	public void move(){
		if(velocity.mag() != 0){
			position.add(velocity);
			
			for(Actor a : world.getActors(TabbyCat.class)){
				collide(a);
			}
			for (Actor a : world.getActors(BreakableObject.class)) {
				collide((BreakableObject)a);
			}
			for(Wall w : world.getWalls()){
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
				PVector adjust = PVector.sub(position, obj.position).normalize().mult((boundary - distance) / 2.0);
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
		float top = min(myTop - wall.bottom, 0);
		float left = min(myLeft - wall.right, 0);

		// positive is a collision; negative is null
		float right = max(myRight - wall.left, 0);
		float bottom = max(myBottom - wall.top, 0);
		
		if (top != 0
		 && left != 0
		 && right != 0
		 && bottom != 0){
			float y = (abs(top) < abs(bottom)) ? top : bottom;
			float x = (abs(left) < abs(right)) ? left : right;
			if (abs(x) < abs(y)){
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
		
		return ((myLeft < wall.right)
		 && (wall.left < myRight)
		 && (myTop < wall.bottom)
		 && (wall.top < myBottom));
	}
}