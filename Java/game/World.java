package Java.game;

import java.util.ArrayList;
import java.util.List;

public class World extends processing.core.PApplet {
	  ArrayList<Actor> actors;
	  
	  static int defaultWidth = 620;
	  static int defaultHeight = 480;
	  
	  int tempWidth = defaultWidth;
	  int tempHeight = defaultHeight;
	  
	  public World() {
	    actors = new ArrayList<>();
	  }
	  
	  public World(int width, int height) {
	    actors = new ArrayList<>();
	    
	    tempWidth = width;
	    tempHeight = height;
	  }
	  
	  @Override
	  public void draw() {
	    for (Actor actor : actors) {
	      actor.draw();
	    }
	  }
	  
	  public void addActor(Actor actor) {
	    actor.world = this;
	    actors.add(actor);
	  }
	  
	  public List<Actor> getActors() {
		  return actors;
	  }
	  
	  public <T extends Actor> List<Actor> getActors(Class<T> subclass) {
		  ArrayList<Actor> filtered = new ArrayList<>();
		  for (Actor actor : actors)
			  if (actor.getClass().equals(subclass))
				  filtered.add(actor);
		  return filtered;
	  }
	  
	  @Override
	  public void settings() {
		  size(tempWidth, tempHeight);
	  }
}