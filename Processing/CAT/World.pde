import ddf.minim.*;
import java.util.List;

public class World {
	// -- constants --
	// music
	private static final String LEVEL_MUSIC = "/assets/Who Likes to Party.mp3";
	
	// -- variables --
	
	Player player;
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<Wall> walls = new ArrayList<Wall>();
    private Button pauseButton;
	private ArrayList<Actor> deletionList = new ArrayList<Actor>();
	private Background background;
	private Music music;
	private Score score;
	
	// -- constructors --
	
	// make world with background and default dimensions
	public World(Background background, Minim minim, Player player) {
		this.background = background;
		this.player = player;
		
        if (music != null) {
            music = new Music(minim);
		    music.switchTrack(LEVEL_MUSIC, true);
        }
        
		this.player = player;
		score = new Score();
	}
	
	// -- methods --
	
	// call this each update to trigger actor and wall updates
	public void display() {
        if (!pauseButton.getPauseState()) {
		    background.display();
	    	for (Wall wall : walls) {
		    	wall.display();
		    }
		    for (Actor actor : actors) {
    			if (actor.display()) {
                    markDeletion(actor);
			    }
		    }
            score.display();

            deletionList = updateDeletionList();
        }
        pauseButton.display();
	}

    public void markDeletion(Actor actor) {
        deletionList.add(actor);   
    }

    public ArrayList<Actor> updateDeletionList() {
        while (deletionList.size() > 0) {
            removeActor(deletionList.remove(0));
        }   
        return deletionList;
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

    public void addButton(Button button) {
        pauseButton = button;
    }
    
    public Button getButton() {
        return pauseButton;   
    }
}