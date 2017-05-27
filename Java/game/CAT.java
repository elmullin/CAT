package game;

import processing.core.*;

public class CAT extends PApplet{

private World world;

public void settings(){
    world.applySettings();
}

public void setup(){
    //scene setup
    surface.setResizable(false);
    world = new World(new Background("bg.png"), 800, 600);
    world.addActor(new TabbyCat(50, 50));
}

public void draw(){
    world.display();
}