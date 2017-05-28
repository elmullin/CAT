package game;

import processing.core.PImage;

public class Actor extends processing.core.PApplet {
  
    // -- variables --
  
    // world actor belongs to
    private World world;
    
    // sprite of actor
    private PImage image;
    
    // points from 0,0 to the object's location
    protected PVector position;
    
    // -- constructors --
    
    // default constructor
    public Actor() {
      //Do nothing default constructor 
    }
    
    // make actor with image
    public Actor(PImage image) {
      setImage(image);
    }
    
    // make actor in position
    public Actor(int x, int y) {
      position = new PVector(x, y);
    }
    
    // make actor in position with image
    public Actor(PImage image, int x, int y) {
      position = new PVector(x, y);
      this.image = image;
    }
    
    // -- methods --
    
    // display actor on screen
    public void display() {
      if (image != null)
        image(image, (int) position.x, (int) position.y);
        //image(image, 0, 0);
        resetMatrix();
        //System.out.println(image.toString());
    }
    
    // change location of actor
    void setLocation(int x, int y) {
      position.x = x;
      position.y = y;
    }
    
    // change image of actor
    void setImage(PImage image) {
      this.image = image;
    }
    
    // change image of actor to given size
    void scaleImage(int x, int y) {
      this.image.resize(x, y);
    }
    
    // scale image of actor by given factor
    void scaleImage(double factor) {
      scaleImage((int) Math.round(factor * width), (int) Math.round(factor * height));
    }
    
    // returns world of this actors as a World
    public World getWorld() {
      return this.world;
    }
    
    // sets the world this actor is in
    public void setWorld(World world) {
      this.world = world;
    }
    
    // removes actor from world
    public void remove() {
        world = null;
        getWorld().removeActor(this);
    }
    
    // returns x-value of actor
    float getX() {
      return position.x;
    }
    
    // returns y-value of actor
    float getY() {
      return position.y;
    }
      
    // returns width of actor
    int getWidth() {
      return width;
    }
      
    // returns height of actor
    int getHeight() {
      return height;
    }
      
    // returns image of actor
    PImage getImage() {
      return image; 
    }
}