import ddf.minim.*;

private World world;
private Minim minim;

PImage catImg;
PImage bgImg;
PImage playerImg;
PImage scoreZoneImg;

Player player;

public void setup(){
	minim = new Minim(this);
	LevelBuilder levelBuilder = new LevelBuilder();
	
	// load images
	bg = loadImage("/assets/bg.png");
	catImg = loadImage("/assets/cat.gif");
	playerImg = loadImage("/assets/PlayerPlaceHolder.gif");
	scoreZoneImg = loadImage("/assets/scorezone.png");
	   
	world = levelBuilder.buildWorld(minim, catImg, bgImg, playerImg);
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