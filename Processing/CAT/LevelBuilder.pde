import ddf.minim.*;

public class LevelBuilder {
   public World buildWorld(Minim minim, PImage catgif, PImage bg, PImage playerImg) {
      //world setup
       surface.setResizable(false);
    
       World world = new World(new Background(bg), minim);
       
       /*
        * Wall setup
        */
        
       // outer walls
       world.addWall(new Wall(-2, -2, 802, 0));
       world.addWall(new Wall(802, -2, 800, 602));
       world.addWall(new Wall(802, 602, -2, 600));
       world.addWall(new Wall(-2, 602, 0, -2));
       
       // inner walls
       world.addWall(new Wall(100, -2, 150, 500));
       world.addWall(new Wall(100, 500, 550, 450));
       world.addWall(new Wall(500, 500, 550, 250));
       
       world.addWall(new Wall(700, 602, 650, 100));
       world.addWall(new Wall(700, 150, 250, 100));
       world.addWall(new Wall(300, 100, 250, 400));

       // actor setup
       world.addActor(new Player(playerImg, 200, 200));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       world.addActor(new TabbyCat(catgif, 100, 100, minim));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));
       world.addActor(new TabbyCat(catgif, 50, 50, minim));

       
       return world;
   }
}