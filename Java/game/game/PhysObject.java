package game;

import processing.core.*;
import java.util.List;

public abstract class PhysObject extends Actor{
    
    // A vector describing the object's movement
    protected PVector velocity;
    
    // the collision radius
    protected float radius;
    
    boolean moveable;
    
    PApplet parent;
    
    
    /* CONSTRUCTORS */
    
    /**
     * Full constructor.
     */
    public PhysObject(PImage image, float posX, float posY, float velX, float velY, 
    float collisionRadius, boolean isMoveable, PApplet p){
        super(image, posX, posY);
        radius = collisionRadius;
        moveable = isMoveable;
        velocity = new PVector(velX, velY);
        parent = p;
    }
    
    /**
     * Imageless constructor.
     */
    public PhysObject(float posX, float posY, float velX, float velY, 
    float collisionRadius, boolean isMoveable, PApplet p){
        super(posX, posY);
        radius = collisionRadius;
        moveable = isMoveable;
        velocity = new PVector(velX, velY);
        parent = p;
    }
    
    /**
     * No-velocity constructor.
     */
    public PhysObject(PImage image, float posX, float posY, float collisionRadius, boolean isMoveable, PApplet p){
        this(image, posX, posY, 0, 0, collisionRadius, isMoveable, p);
    }
    
    /**
     * No-image constructor.
     */
    public PhysObject(float posX, float posY, float collisionRadius, boolean isMoveable, PApplet p){
        this(posX, posY, 0, 0, collisionRadius, isMoveable, p);
    }
    
    /* MOVEMENT */
    
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
    
    public void collide(List<Object> list){
        for(Object a: list){
            if(a instanceof PhysObject){
                collide((PhysObject) a);
            }
            else if(a instanceof Wall){
                collide((Wall) a);
            }
        }
    }
    
    /**
     * Checks whether this collides with the given PhysObject.
     * If it does, bumps it to the closest open spot.
     */
    public void collide(PhysObject obj){
        float distance = position.dist(obj.position);
        float boundary = radius + obj.radius;
        
        if (distance < boundary) {
            if(obj.moveable){
                PVector adjust = PVector.sub(position, obj.position).normalize().mult((float)((boundary - distance) / 2.0));
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
    public void collide(Wall wall){
        float top = wall.bottom - (position.y + radius);
        float right = wall.left - (position.x + radius);
        float bottom = wall.top - (position.y - radius);
        float left = wall.right - (position.x - radius);
        
        float x = PApplet.abs(left) < PApplet.abs(right)? left : right;
        float y = PApplet.abs(top) < PApplet.abs(bottom)? top : bottom;
        
        if (PApplet.abs(x) < PApplet.abs(y)){
            position.add(x, 0);
        }
        else {
            position.add(0, y);
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
        
        //double check your math here >>;
        
        if (wall.bottom < (position.y - radius)
         || wall.left < (position.x + radius)
         || wall.top > (position.y + radius)
         || wall.right > (position.x - radius)){
             return false;
         }
        else{
            return true;
            //TODO - this actually means the box is inside the other box, double check closest corner
        }
    }
}