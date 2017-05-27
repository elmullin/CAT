private World world;

public void settings(){
    size(800, 600);
}

public void setup(){
    // -- load images --
    PImage catgif = loadImage("assets/cat.gif");
  
    //world setup
    surface.setResizable(false);
    world = new World(new Background("bg.png"));
    
    // actor setup
    world.addActor(new TabbyCat(catgif, 50, 50));
}

public void draw(){
    world.display();
}