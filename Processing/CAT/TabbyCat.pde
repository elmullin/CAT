public class TabbyCat extends PhysObject {
    
    PImage sprite;
    
    public TabbyCat(int x, int y){
        super(true, x, y);
        sprite = loadImage("assets/cat.gif");
    }
    
    public void display(){
        image(sprite, position.x, position.y);
        resetMatrix();
    }
}