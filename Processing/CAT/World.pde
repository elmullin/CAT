import processing.core.PImage;

public class World extends processing.core.PApplet {
  
    // -- variables --
  
    // array to hold actors
    ArrayList<Actor> actors = new ArrayList<Actor>();
    
    // default world size if not given
    static final int defaultWidth = 620;
    static final int defaultHeight = 480;
    
    // non-default world dimensions
    int tempWidth = defaultWidth;
    int tempHeight = defaultHeight;
    
    // background image
    Background background;
    
    //  -- constructors --
    
    // default constructor
    public World() {
      // default constructor
    }
    
    // make world with dimensions
    public World(int width, int height) {
      tempWidth = width;
      tempHeight = height;
    }
    
    // make world with background and default dimensions
    public World(Background background) {
      this.background = background;
    }
    
    // make world with background and given dimnnsions
    public World(Background background, int width, int height) {
      this.background = background;
      
      tempWidth = width;
      tempHeight = height;
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
      actor.world = this;
      actors.add(actor);
    }
    
    // remove an actor from the list of actors belonging to this world
    public void removeActor(Actor actor) {
      actor.world = null;
      actors.remove(actor);
    }
    
    // return an array of all actors
    public ArrayList<Actor> getActors() {
      return actors;
    }
    
    // return an array of actors matching a given class
    public <T extends Actor> ArrayList<Actor> getActors(Class<T> subclass) {
      ArrayList<Actor> filtered = new ArrayList<Actor>();
      for (Actor actor : actors)
        if (actor.getClass().equals(subclass))
          filtered.add(actor);
      return filtered;
    }
    
    // resizes world and changes background
    public void applySettings() {
      size(tempWidth, tempHeight);
    }
}