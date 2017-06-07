import ddf.minim.*;

private World world;

PImage catImg;
PImage bgImg;
PImage playerImg;
PImage scoreZoneImg;

Player player;

public void setup(){
	Minim minim = new Minim(this);
	LevelBuilder levelBuilder = new LevelBuilder();
	
	// load images
	bgImg = loadImage("assets/bg.gif");
	catImg = loadImage("assets/cat.gif");
	playerImg = loadImage("assets/player.gif");
	scoreZoneImg = loadImage("assets/scorezone.png");
	
	world = levelBuilder.buildWorld(minim, bgImg, playerImg, catImg, scoreZoneImg);
	player = (Player)(world.getActors(Player.class).get(0));
}

public void draw(){
	imageMode(CENTER);
	world.display();
}

public void settings(){
	size(800, 600);
}

public void keyPressed() {
	player.pressKey(key);
}

public void keyReleased() {
	player.releaseKey(key);
}

public void mousePressed() {
    if (world.getButton().overRect()) {
        world.getButton().pressMouse();
    }
}