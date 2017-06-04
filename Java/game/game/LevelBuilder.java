package game;

import processing.core.*;
import ddf.minim.*;

public class LevelBuilder {
	PApplet parent;
	
    public World buildWorld(Minim minim, PImage catgif, PImage bg, PImage playerImg, PApplet p) {
        parent = p;
    	
    	//world setup
    
        World world = new World(new Background(bg, parent), minim);
       
        /*
         * Wall setup
         */
        
        // outer walls
        world.addWall(new Wall(-2, -2, 802, 0, parent));
        world.addWall(new Wall(802, -2, 800, 602, parent));
        world.addWall(new Wall(802, 602, -2, 600, parent));
        world.addWall(new Wall(-2, 602, 0, -2, parent));
       
        // inner walls
        world.addWall(new Wall(100, -2, 150, 500, parent));
        world.addWall(new Wall(100, 500, 550, 450, parent));
        world.addWall(new Wall(500, 500, 550, 250, parent));
       
        world.addWall(new Wall(700, 602, 650, 100, parent));
        world.addWall(new Wall(700, 150, 250, 100, parent));
        world.addWall(new Wall(300, 100, 250, 350, parent));

        // actor setup
        world.addActor(new Player(playerImg, 50, 50, parent));
       
        world.addActor(new TabbyCat(catgif, 400, 300, minim, parent));
        world.addActor(new TabbyCat(catgif, 200, 50, minim, parent));
        world.addActor(new TabbyCat(catgif, 300, 550, minim, parent));
        world.addActor(new TabbyCat(catgif, 50, 200, minim, parent));
        world.addActor(new TabbyCat(catgif, 750, 50, minim, parent));

        world.addActor(new ScoreZone(750, 600, 50, parent));
       
        return world;
   }
}