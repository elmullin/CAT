public class ScoreZone extends Actor {
	
	public ScoreZone(PImage sprite, float x, float y, float radius){
		super(sprite, x, y, radius, false);
	}
	
	public void scoreCat(TabbyCat target){
		getWorld().score.incrementCatsCorralled();
		getWorld().removeActor(target);
	}
}