package game;

import processing.core.*;

public abstract class PhysObject extends PApplet{
    
    /* points from 0,0 to the object's location */
    private PVector position;
    
    /**
     * A vector describing the object's movement:
     *     - the direction is the direction the object is facing
     *     - the magnitude is the speed the object is moving
     */
    private PVector velocity;
    
    /* the collision radius */
    private float radius;

    /**
     * Constructor. Creates a new object at the given location.
     */
    public PhysObject(int x, int y){
        position = new PVector(x, y);
        velocity = new PVector(0, 0);
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
     * By default, stops.
     */
    public void collision(PhysObject other){
        if(collidesWith(other)){
            //TODO set to where radii meet along the velocity vector
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
       velocity.rotate((-1 * velocity.heading()) + amt);
    }
}
