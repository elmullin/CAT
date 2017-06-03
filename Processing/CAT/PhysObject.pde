public abstract class PhysObject extends Actor{
    
    // points from 0,0 to the object's location
    protected PVector position;
    
    // A vector describing the object's movement
    protected PVector velocity;
    
    // the collision radius
    protected float radius;
    
    boolean moveable;
    
    /**
     * Constructor. Creates a new object at the given location.
     */
    public PhysObject(boolean isMoveable, int x, int y){
		super(x, y);
        moveable = isMoveable;
        position = new PVector(x, y);
        velocity = new PVector(0, 0);
    }
	
	/**
     * Constructor. Creates a new object with an image at the given location.
     */
    public PhysObject(PImage image, boolean isMoveable, int x, int y){
        super(image, x, y);
        moveable = isMoveable;
		position = new PVector(x, y);
        velocity = new PVector(0, 0);
    }
    
    /**
     * Constructor. Creates a new object at the given location with the given velocity.
     */
    public PhysObject(boolean isMoveable, int posX, int posY, int velX, int velY){
		super(image, posX, posY);
        moveable = isMoveable;
        position = new PVector(posX, posY);
        velocity = new PVector(velX, velY);
    }
	
	/**
     * Constructor. Creates a new object with an image at the given location with the given velocity.
     */
    public PhysObject(PImage image, boolean isMoveable, int posX, int posY, int velX, int velY){
        super(image, posX, posY);
        moveable = isMoveable;
		position = new PVector(posX, posY);
        velocity = new PVector(velX, velY);
    }
    
    /**
     * Performs a collision check with a PhysObject.
     */
    private boolean collidesWith(PhysObject obj){
        float distance = position.dist(obj.position);
        float boundary = radius + obj.radius;
        
        return distance < boundary;
    }
    
    /**
     * Performs a collision check with a wall.
     */
    private boolean collidesWith(Wall wall){
        
        //double check your math here >>;
        
        if (wall.bottom < (position.y - radius)
         || wall.left < (position.x + radius)
         || wall.top > (position.y + radius)
         || wall.right > (position.x - radius)){
             return false;
         }
        else{
            // box inside box, double check closest corner
        }
    }
    
    /* collsion for two round objects */
    private void collide(PhysObject obj){
        float distance = position.dist(obj.position);
        float boundary = radius + obj.radius;
        
        if (distance < boundary) {
            if(obj.moveable){
                PVector adjust = PVector.sub(position, obj.position).normalize().mult((boundary - distance) / 2.0);
                position.add(adjust);
                obj.position.add(adjust);
            }
            else {
                position.add(PVector.sub(position, obj.position).normalize().mult(boundary - distance));
            }
        }
    }
    
    /* collsion for a wall and a round object
       note: this could probably be optimized
       note: if this isn't working, try flipping wall.x and ()
       */
    private void collide(Wall wall){
        float top = wall.bottom - (position.y + radius);
        float right = wall.left - (position.x + radius);
        float bottom = wall.top - (position.y - radius);
        float left = wall.right - (position.x - radius);
        
        float x = abs(left) < abs(right)? left : right;
        float y = abs(top) < abs(bottom)? top : bottom;
        
        if (abs(x) < abs(y)){
            position.add(x, 0);
        }
        else {
            position.add(0, y);
        }
    }
    
    /**
     * Moves the object in the direction of the velocity.
     */
    public void move(){
        position.add(velocity);
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
     */
    public void setSpeed(float amt){
        velocity.setMag(amt);
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
     */
    public void setAngle(float amt){
        velocity.rotate((-1 * velocity.heading()) + amt);
    }
}