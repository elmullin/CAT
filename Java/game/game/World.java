package game;

import java.util.ArrayList;
import java.util.List;
import processing.core.*;
import ddf.minim.*;

public class World {
    // -- constants --

    // music
    private static final String LEVEL_MUSIC = "/assets/Who Likes to Party.mp3";

    // -- variables --
  
    //player object
    Player player;
    
    // array to hold actors
    ArrayList<Actor> actors = new ArrayList<Actor>();
    
    // array to hold walls
    ArrayList<Wall> walls = new ArrayList<Wall>();
    
    // background image
    Background background;

    // music
    Music music;
    
    //score
    public Score score;
    
    //  -- constructors --
    
    // default constructor
    public World(Minim minim) {
      music = new Music(minim);
      music.switchTrack(LEVEL_MUSIC, true);
      
    }
    
    // make world with background and default dimensions
    public World(Background background, Minim minim) {
      this.background = background;
      music = new Music(minim);
      music.switchTrack(LEVEL_MUSIC, true);
    }
    
    // -- methods --
    
    // call this each update to trigger actor and wall updates
    public void display() {
      background.display();
      for (Wall wall : walls) {
         wall.display();  
      }
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
    
    public void addWall(Wall wall) {
        walls.add(wall);  
    }
}