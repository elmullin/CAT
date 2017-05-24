package game;

import processing.core.*;

public abstract class PhysObject extends PApplet{
    
    // points from 0,0 to the object's location
    private PVector position;
    
    // A vector describing the object's movement
    private PVector velocity;
    
    // the collision radius
    private float radius;
    
    boolean immovable;
    
    /**
     * Constructor. Creates a new object at the given location.
     */
    public PhysObject(int x, int y){
        position = new PVector(x, y);
        velocity = new PVector(0, 0);
        immovable = true;
    }
    
    /**
     * Constructor. Creates a new object at the given location with the given velocity.
     */
    public PhysObject(int posX, int posY, int velX, int velY){
        position = new PVector(posX, posY);
        velocity = new PVector(velX, velY);
    }
    
    /**
     * What this object should do on collision with another object.
     * Default behavior is wall-like.
     */
    public void collision(PhysObject other){
		
		float distance = position.dist(other.position);
        float boundary = radius + other.radius;
        
        if (distance < boundary) {
            if(other.immovable){
                position.add(PVector.sub(position, other.position).normalize().mult(boundary - distance));
            }
            else {
                PVector adjust = PVector.sub(position, other.position).normalize().mult((boundary - distance) / 2.0);
                position.add(adjust);
                other.position.add(adjust);
            }
        }
    }
    
    /**
     * Performs a collision check with the given object.
     */
    public boolean collidesWith(PhysObject other){
        float boundary = radius + other.radius;
        return position.dist(other.position) < boundary;
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
