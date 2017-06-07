package game;
import processing.core.*;

public class ScoreZone extends Actor {
	
	public ScoreZone(PImage sprite, float x, float y, float radius, PApplet p){
		super(sprite, x, y, radius, false, p);
	}
	
	public void scoreCat(TabbyCat target){
		getWorld().getScore().incrementCatsCorralled();
		getWorld().removeActor(target);
	}
}