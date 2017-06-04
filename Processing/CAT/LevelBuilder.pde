import ddf.minim.*;

public class LevelBuilder {
   public World buildWorld(Minim minim) {
      
    // -- load images --
    PImage catgif = loadImage("assets/cat.gif");
    PImage bg = loadImage("assets/bg.png");
    PImage playerImg = loadImage("PlayerPlaceHolder.png");
  
    //world setup
    surface.setResizable(false);
    World world = new World(new Background(bg), minim);
    
    // actor setup
    world.addActor(new Player(playerImg, 200, 200));
    world.addActor(new TabbyCat(catgif, 50, 50, minim));
    world.addActor(new TabbyCat(catgif, 50, 50, minim));
    world.addActor(new TabbyCat(catgif, 50, 50, minim));
    world.addActor(new TabbyCat(catgif, 50, 50, minim));
    world.addActor(new TabbyCat(catgif, 50, 50, minim));
    
    return world;
   }
}