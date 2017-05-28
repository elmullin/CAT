package game;

import java.util.ArrayList;
import java.util.List;
import processing.core.PImage;

public class World extends processing.core.PApplet {
  
    // -- variables --
  
    // array to hold actors
    ArrayList<Actor> actors = new ArrayList<Actor>();
    
    // background image
    Background background;
    
    //  -- constructors --
    
    // default constructor
    public World() {
      // default constructor
    }
    
    // make world with background and default dimensions
    public World(Background background) {
      this.background = background;
    }
    
    // -- methods --
    
    // call this each update to trigger actor updates
    public void display() {
      background.display();
      for (Actor actor : actors) {
        actor.display();
      }
    }
    
    // add an actor to the list of updating actors
    public void addActor(Actor actor) {
      actor.setWorld(this);
      actors.add(actor);
    }
    
    // remove an actor from the list of actors belonging to this world
    public void removeActor(Actor actor) {
      actor.setWorld(null);
      actors.remove(actor);
    }
    
    // return an array of all actors
    public List<Actor> getActors() {
      return actors;
    }
    
    // return an array of actors matching a given class
    public <T extends Actor> List<Actor> getActors(Class<T> subclass) {
      ArrayList<Actor> filtered = new ArrayList<Actor>();
      for (Actor actor : actors)
        if (actor.getClass().equals(subclass))
          filtered.add(actor);
      return filtered;
    }
}