import ddf.minim.*;

private World world;
private Minim minim;

//public PImage test;

public void setup(){
   minim = new Minim(this);
   LevelBuilder levelBuilder = new LevelBuilder();
   
   world = levelBuilder.buildWorld(minim);
}

public void draw(){
    world.display();
}

public void settings(){
    size(800, 600);
}