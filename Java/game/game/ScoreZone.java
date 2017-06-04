package game;
import processing.core.*;

public class ScoreZone extends PhysObject {
  
  public ScoreZone(float x, float y, float radius, PApplet p){
    super(x, y, radius, false, p);
    parent = p;
  }
  
  public void scoreCat(TabbyCat target){
    getWorld().score.incrementCatsCorralled();
    getWorld().removeActor(target);
  }//close scoreCat
  
  public void display() {
     // empty so that program does not crash if Actor's display method run on SccoreZone
     parent.ellipse(position.x, position.y, 100, 100);
  }

}