package Java.game;

import processing.core.PImage;

public class Actor extends processing.core.PApplet {
	  World world;
	  
	  PImage image;
	  
	  private int x = 0;
	  private int y = 0;
	  
	  public Actor() {
		//Do nothing default constructor
	  }
	  
	  public Actor(String image) {
	    setImage(image);
	  }
	  
	  public Actor(int x, int y) {
	    setLocation(x, y);
	  }
	  
	  public Actor(String image, int x, int y) {
	    setLocation(x, y);
	    setImage(image);
	  }
	  
	  @Override
	  public void draw() {
	    if (image != null)
	      image(image, x, y);
	  }
	  
	  void setLocation(int x, int y) {
	    this.x = x;
	    this.y = y;
	  }
	  
	  void setImage(String image) {
	    this.image = loadImage(image);
	  }
	  
	  void scaleImage(int x, int y) {
	    this.image.resize(x, y);
	  }
	  
	  void scaleImage(double factor) {
	    scaleImage((int) Math.round(factor * width), (int) Math.round(factor * height));
	  }
	  
	  public World getWorld() {
	    return this.world;
	  }
	  
	  int getX() {
	    return x;
	  }
	  
	  int getY() {
	    return y;
	  }
	    
	  int getWidth() {
	    return width;
	  }
	    
	  int getHeight() {
	    return height;
	  }
	    
	  PImage getImage() {
	    return image; 
	  }
	}