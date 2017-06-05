import processing.core.PImage;
import java.util.List;

public class World {
	// -- constants --
	// music
	private static final String LEVEL_MUSIC = "/assets/Who Likes to Party.mp3";
	
	// -- variables --
	
	Player player;
	ArrayList<Actor> actors = new ArrayList<Actor>();
	ArrayList<Wall> walls = new ArrayList<Wall>();
    ArrayList<Actor> deletionList = new ArrayList<Actor>();
	Background background;
	Music music;
	private Score score;
	
	// -- constructors --
	
	// make world with background and default dimensions
	public World(Background background, Minim minim, Player player) {
		this.background = background;
		this.player = player;
		music = new Music(minim);
        music.switchTrack(LEVEL_MUSIC, true);
        this.player = player;
        score = new Score();
	}
	
	// -- methods --
	
	// call this each update to trigger actor and wall updates
	public void display() {
		background.display();
		for (Wall wall : walls) {
			wall.display();
		}
		for (Actor actor : actors) {
			if (actor.display()) {
                deletionList.add(actor);
            }
		}
        while (deletionList.size() > 0) {
            removeActor(deletionList.get(0));
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
		for (Actor actor : actors) {
			if (actor.getClass().equals(subclass)) {
				filtered.add(actor);
			}
		}
		return filtered;
	}
	
	public void addWall(Wall wall) {
		walls.add(wall);
	}

	public List<Wall> getWalls() {
        return walls;
    }
    
    public Score getScore() {
        return score;   
    }
}