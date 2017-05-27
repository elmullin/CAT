private Background bg;
private PhysObject cat;

public void settings(){
    size(800, 600);
}

public void setup(){
    //scene setup
    surface.setResizable(false);
    bg = new Background("bg.png");
    cat = new TabbyCat(50, 50);
}

public void draw(){
    bg.display();
    cat.display();
}