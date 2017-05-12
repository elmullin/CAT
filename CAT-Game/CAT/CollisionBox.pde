public class PhysObject{
    
    /**
     * A vector describing the object's location:
     *     - the origin is the center of the object
     *     - the direction is the direction the object is facing
     *     - the magnitude is the radius of the collision sphere
     */
    private PVector body;
    
    /**
     * A vector describing the object's movement:
     *     - the origin is the center of the object
     *     - the direction is the direction the object is moving
     *     - the magnitude is the speed the object is moving
     */
    private PVector velocity;
    
    /**
     * Constructor. Creates a new object at the given location.
     */
    public PhysObject(int x, int y){
        body = new PVector(x, y);
        velocity = new PVector(x, y);
    }
    
    /**
     * Performs a collision check with the given object.
     */
    public boolean collidesWith(PhysObject other){
        float boundary = body.mag() + other.body.mag();
        return body.dist(other.body) < boundary;
    }
    
    /**
     * Moves the object in the direction of the velocity.
     */
    public void move(){
        // TODO
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
        //TODO
    }
}