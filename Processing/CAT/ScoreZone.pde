import processing.core.PImage;

public class ScoreZone extends PhysObject {
  
  public ScoreZone(int x, int y){
    super(false, x, y);
  }
  
  public void scoreCat(TabbyCat scored){
    getWorld().score.incrementCatsCorralled();
    getWorld().removeActor(scored);
  }//close scoreCat

}