import processing.core.*;

public class ScoreZone extends PhysObject {
  
  public ScoreZone(float x, float y, float radius){
    super(x, y, radius, false);
  }
  
  public void scoreCat(TabbyCat target){
    getWorld().score.incrementCatsCorralled();
    getWorld().removeActor(target);
  }//close scoreCat
  
  public void display() {
     // empty so that program does not crash if Actor's display method run on SccoreZone
     ellipse(position.x, position.y, 100, 100);
  }

}