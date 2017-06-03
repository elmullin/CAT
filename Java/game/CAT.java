package game;

import processing.core.*;

public class CAT extends PApplet{

   private World world;

   public void settings(){
       size(800, 600);
   }

   public void setup(){
      //scene setup
      surface.setResizable(false);
      world = new World(new Background("bg.png"));
    
      PhysObject cat = new TabbyCat(50, 50);
    
      world.addActor(cat);
   }

   public void draw(){
      world.display();
   }
}
