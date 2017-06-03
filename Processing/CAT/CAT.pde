private World world;

//public PImage test;

public void setup(){
    // -- load images --
    PImage catgif = loadImage("assets/cat.gif");
    PImage bg = loadImage("assets/bg.png");
    
    //test = catgif;
  
    //world setup
    surface.setResizable(false);
    world = new World(new Background(bg));
    
    // actor setup
    world.addActor(new TabbyCat(catgif, 50, 50));
}

public void draw(){
    world.display();
    
    //image(test, 0,0);
    //test(test);
}

public void settings(){
    size(800, 600);
}

//public void test(PImage image) {
//    image(image, 0, 0);
//}