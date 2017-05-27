package game;

import processing.core.PImage;

public class Actor extends processing.core.PApplet {
  
    // -- variables --
  
    // world actor belongs to
    private World world;
    
    // sprite of actor
    private PImage image;
    
    // pixel coordinates of actor
    private int x = 0;
    private int y = 0;
    
    // -- constructors --
    
    // default constructor
    public Actor() {
      //Do nothing default constructor 
    }
    
    // make actor with image
    public Actor(String image) {
      setImage(image);
    }
    
    // make actor in position
    public Actor(int x, int y) {
      setLocation(x, y);
    }
    
    // make actor in position with image
    public Actor(String image, int x, int y) {
      setLocation(x, y);
      setImage(image);
    }
    
    // -- methods --
    
    // display actor on screen
    public void display() {
      if (image != null)
        image(image, x, y);
    }
    
    // change location of actor
    void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
    }
    
    // change image of actor
    void setImage(String image) {
      this.image = loadImage(image);
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
    
    // returns world of this actor, cast to the subclass passed in - will return null if the class does not cast correctly
    public <T extends World> T getWorld(Class<T> subclass) {
      try {
          return subclass.cast(world);
      } catch(ClassCastException e) {
          return null;
      }
    }
    
    // removes actor from world
    public void remove() {
        getWorld().removeActor(this);
    }
    
    // returns x-value of actor
    int getX() {
      return x;
    }
    
    // returns y-value of actor
    int getY() {
      return y;
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