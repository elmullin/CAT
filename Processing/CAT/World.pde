import processing.core.PImage;
import java.util.List;

public class World extends processing.core.PApplet {
    // -- constants --

    // music
    private static final String LEVEL_MUSIC = "assets/Who Likes to Party.mp3";

    // -- variables --
  
    //player object
    Player player;
    
    // array to hold actors
    ArrayList<Actor> actors = new ArrayList<Actor>();
    
    // background image
    Background background;

    // music
    Music music;
    
    //score
    public Score score;
    
    //  -- constructors --
    
    // default constructor
    public World() {
      // default constructor
      music = new Music();
      music.switchTrack(LEVEL_MUSIC, true);
      player = new Player(0, 0); //TODO update to start postion later
      
    }
    
    // make world with background and default dimensions
    public World(Background background) {
      this.background = background;
      music = new Music();
      music.switchTrack(LEVEL_MUSIC, true);
      player = new Player(0, 0); //TODO update to start postion later
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