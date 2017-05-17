public class Background{
    private PImage bg;
        
    public Background(String fileName){
        bg = loadImage("assets/" + fileName);
    }
        
    public void display(){
        image(bg, 0, 0);
        resetMatrix();
    }
}