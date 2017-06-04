public class ScoreZone extends Actor {
	
	public ScoreZone(PImage sprite, float x, float y, float radius){
		super(sprite, x, y, radius, false);
	}
	
	public void scoreCat(TabbyCat target){
		getWorld().score.incrementCatsCorralled();
		getWorld().removeActor(target);
	}//close scoreCat
	
	public void display() {
		 // empty so that program does not crash if Actor's display method run on SccoreZone
		 ellipse(super.position.x, super.position.y, 100, 100);
	}

}