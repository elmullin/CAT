import ddf.minim.*;

public class LevelBuilder {
   public World buildWorld(Minim minim, PImage catgif, PImage bg, PImage playerImg) {
      //world setup
       surface.setResizable(false);
    
       World world = new World(new Background(bg), minim);
       
       // actor setup
       world.addActor(new Player(playerImg, 200, 200));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       world.addActor(new TabbyCat(catgif, 100, 100, minim));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       
       // wall setup
       world.addWall(new Wall(-2, -2, 802, 0));
       world.addWall(new Wall(802, -2, 800, 602));
       world.addWall(new Wall(802, 602, -2, 600));
       world.addWall(new Wall(-2, 602, 0, -2));
       
       return world;
   }
}