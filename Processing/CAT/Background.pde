public class Background{
    private PImage bg;
        
    public Background(PImage bg){
        this.bg = bg;
    }
        
    public void display(){
        if (bg != null)
          image(bg, 400, 300);
        resetMatrix();
    }
}