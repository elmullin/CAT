import ddf.minim.*;

public class LevelBuilder {
	public World buildWorld(Minim minim, PImage bgImg, PImage playerImg, PImage catImg, PImage scoreZoneImg) {
        Player player = new Player(playerImg, 50, 50); // passed into world, actor list
		//world setup
		surface.setResizable(false);
	
		World world = new World(new Background(bgImg), minim, player);
		
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
		world.addWall(new Wall(300, 100, 250, 350));

		// actor setup
		
		world.addActor(new TabbyCat(catImg, 400, 300, minim));
		world.addActor(new TabbyCat(catImg, 200, 50, minim));
		world.addActor(new TabbyCat(catImg, 300, 550, minim));
		world.addActor(new TabbyCat(catImg, 50, 200, minim));
		world.addActor(new TabbyCat(catImg, 750, 50, minim));

        world.addActor(new BreakableObject(5000, null, 475, 425, 25));

		world.addActor(new ScoreZone(scoreZoneImg, 750, 600, 50));

        world.addActor(player);
		
		return world;
	}
}