package game;

import processing.core.*;
import ddf.minim.*;

public class LevelBuilder {
	
	PApplet parent;
	
	public World buildWorld(Minim minim, PImage bgImg, PImage playerImg, PImage catImg, PImage scoreZoneImg, PApplet p) {
		Player player = new Player(playerImg, 50, 100, p); // passed into world, actor list
		//world setup
		parent = p;
	
		World world = new World(new Background(bgImg, parent), minim, player, parent);
		
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
		
		world.addActor(new TabbyCat(catImg, 400, 300, minim, parent));
		world.addActor(new TabbyCat(catImg, 200, 50, minim, parent));
		world.addActor(new TabbyCat(catImg, 300, 550, minim, parent));
		world.addActor(new TabbyCat(catImg, 50, 200, minim, parent));
		world.addActor(new TabbyCat(catImg, 750, 50, minim, parent));

		world.addActor(new BreakableObject(500, null, 475, 425, 25, parent));

		world.addActor(new ScoreZone(scoreZoneImg, 750, 600, 50, parent));

        world.addButton(new Button(700, 0, 50, 100, parent));

		world.addActor(player);
		
		return world;
	}
}