public class ScoreZone extends PhysObject {
  
  public ScoreZone(PImage image, float x, float y, float radius){
    super(image, x, y, radius, false);
  }
  
  public void scoreCat(TabbyCat target){
    getWorld().score.incrementCatsCorralled();
    getWorld().removeActor(target);
  }//close scoreCat
  
  public void display() {
     // meant to be empty so that program does not crash if Actor's display method run on SccoreZone
  }

}