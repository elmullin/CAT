import processing.core.PImage;

public class World extends processing.core.PApplet {
    ArrayList<Actor> actors = new ArrayList<Actor>();
    
    static int defaultWidth = 620;
    static int defaultHeight = 480;
    
    int tempWidth = defaultWidth;
    int tempHeight = defaultHeight;
    
    PImage image;
    
    public World() {
    }
    
    public World(int width, int height) {
      tempWidth = width;
      tempHeight = height;
    }
    
    public World(PImage image) {
      this.image = image;
    }
    
    public World(PImage image, int width, int height) {
      this.image = image;
      
      tempWidth = width;
      tempHeight = height;
    }
    
    public void draw() {
      for (Actor actor : actors) {
        actor.draw();
      }
    }
    
    public void addActor(Actor actor) {
      actor.world = this;
      actors.add(actor);
    }
    
    public ArrayList<Actor> getActors() {
      return actors;
    }
    
    public <T extends Actor> ArrayList<Actor> getActors(Class<T> subclass) {
      ArrayList<Actor> filtered = new ArrayList<Actor>();
      for (Actor actor : actors)
        if (actor.getClass().equals(subclass))
          filtered.add(actor);
      return filtered;
    }
    
    public void settings() {
      size(tempWidth, tempHeight);
      background(image);
    }
}