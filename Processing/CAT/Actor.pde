import processing.core.PImage;

public class Actor extends processing.core.PApplet {
  
    // -- variables --
  
    // world actor belongs to
    private World world;
    
    // sprite of actor
    private PImage sprite;
    
    // points from 0,0 to the object's location
    protected PVector position;
    
    // -- constructors --
    
    // make actor with sprite
    public Actor(PImage sprite) {
      setImage(sprite);
      position = new PVector(0,0);
    }
    
    // make actor in position
    public Actor(int x, int y) {
      position = new PVector(x, y);
    }
    
    // make actor in position with sprite
    public Actor(PImage sprite, int x, int y) {
      //System.out.println("in constructor with sprite: " + sprite.toString());
      position = new PVector(x, y);
      this.sprite = sprite;
    }
    
    // -- methods --
    
    // display actor on screen
    public void display() {
      if (sprite != null) {
        //System.out.println(sprite.toString());//
        //image(sprite, position.x, position.y);
        image(sprite, 1, 1);
      }
        //resetMatrix();
        //System.out.println(sprite.toString());
    }
    
    // change location of actor
    void setLocation(int x, int y) {
      position.x = x;
      position.y = y;
    }
    
    // change sprite of actor
    void setImage(PImage sprite) {
      this.sprite = sprite;
    }
    
    // change sprite of actor to given size
    void scaleImage(int x, int y) {
      this.sprite.resize(x, y);
    }
    
    // scale sprite of actor by given factor
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
      
    // returns sprite of actor
    PImage getImage() {
      return sprite; 
    }
}