import ddf.minim.*;

public class TabbyCat extends Actor {
	/*
	 * Constants
	 */
	private static final String SOUND_1 = "assets/Cat_Meow_1.mp3";
	private static final String SOUND_2 = "assets/Cat_Meow_2.mp3";
	private static final String SOUND_3 = "assets/Cat_Meow_3.mp3";
	private static final String SOUND_4 = "assets/Cat_Meow_4.mp3";
	private static final String SOUND_5 = "assets/Cat_Meow_5.mp3";
	private static final String SOUND_6 = "assets/Cat_Meow_6.mp3";
	private static final String SOUND_7 = "assets/Cat_Meow_7.mp3";
	private static final String SOUND_8 = "assets/Cat_Purr_1.mp3";

	private static final int CATSPEED = 4; //speed of cats movement per 
	private static final int FLEERAD = 100;
	private static final int CMC = 5; //1 in X chance each second for moving state to change
	private static final int CDC = 5; //in in X chance each second to change direction while moving

	/*
	 * Fields
	 */
	private Music catSounds;
	private int startTime;
	private float waitTime;

	private boolean moving = false;
	private int lastSec = 0;

	// -------------------------------------------------------------------------

	public TabbyCat(PImage image, float x, float y, Minim minim){
		super(image, x, y, 12, true);
		catSounds = new Music(minim, SOUND_1);
		startTime = millis();
		waitTime = random(5000) + 10000;
	}

	// -------------------------------------------------------------------------

    @Override
    public void move() { // like physObject move, but also check for ScoreZone
        super.move();
        collide(world.getActors(ScoreZone.class).get(0));
    }

	private void makeNoise() {
		if (millis() >= startTime + waitTime) {
			switch ((int)random(8) + 1) {
			case 1:
				catSounds.switchTrack(SOUND_1, false);
				break;
			case 2:
				catSounds.switchTrack(SOUND_2, false);
				break;
			case 3:
				catSounds.switchTrack(SOUND_3, false);
				break;
			case 4:
				catSounds.switchTrack(SOUND_4, false);
				break;
			case 5:
				catSounds.switchTrack(SOUND_5, false);
				break;
			case 6:
				catSounds.switchTrack(SOUND_6, false);
				break;
			case 7:
				catSounds.switchTrack(SOUND_7, false);
				break;
			case 8:
				catSounds.switchTrack(SOUND_8, false);
				break;
			}
			startTime = millis();
			waitTime = random(5000) + 11000;
		}
	}

	public void flee(){
		moving = true;
		velocity = PVector.sub(position, world.player.position);
		velocity.normalize().mult(CATSPEED);
	}

	public void changeDir(){
		velocity = PVector.random2D();
		velocity.mult(CATSPEED);
	}//close changeDir

	public void alone(){
	int curSec = second();

	if(curSec != lastSec){
		lastSec = curSec;
		
		if(int(random(CMC)) == 0){
			moving = !moving;
			if(moving){
				changeDir();
			}//close if moving
		}//close if changing move state
		
		if(moving){
			if(int(random(CDC)) == 0){
				changeDir();
			}//close if changing direction
		}//close if moving
	}//close timing if

	}//close pathing

	public void pathing(){
		if(dist(getWorld().player.position.x, getWorld().player.position.y, position.x, position.y) <= FLEERAD){
			flee();
		}else{
			alone();
		}
	}

	public void scoreCat() {
		world.getScore().incrementCatsCorralled();
		markDelete();
	}
	
	public void extraEffect(PhysObject obj) {
		if (obj instanceof BreakableObject) {
			((BreakableObject)obj).breakObject();
		}
		else if (obj instanceof ScoreZone) {
			scoreCat();
		}
	}

	public boolean display() {
		pathing();
		if(moving){
			move();
		}
		super.display();
		makeNoise();
		return deletionMark;
	}//close display
}