package game;

import processing.core.*;
import ddf.minim.*;

public class TabbyCat extends Actor {
	/*
	 * Constants
	 */
	private static final String SOUND_1 = "/assets/Cat_Meow_1.mp3";
	private static final String SOUND_2 = "/assets/Cat_Meow_2.mp3";
	private static final String SOUND_3 = "/assets/Cat_Meow_3.mp3";
	private static final String SOUND_4 = "/assets/Cat_Meow_4.mp3";
	private static final String SOUND_5 = "/assets/Cat_Meow_5.mp3";
	private static final String SOUND_6 = "/assets/Cat_Meow_6.mp3";
	private static final String SOUND_7 = "/assets/Cat_Meow_7.mp3";
	private static final String SOUND_8 = "/assets/Cat_Purr_1.mp3";

	private static final int CATSPEED = 4; //speed of cats movement per 
	private static final int FLEERAD = 100;
	private static final int CMC = 10; //1 in X chance each second for moving state to change
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

	public TabbyCat(PImage image, float x, float y, Minim minim, PApplet p){
		super(image, x, y, 12, true, p);
		parent = p;
      if (minim != null) {
   		catSounds = new Music(minim, SOUND_1);
      }
		startTime = parent.millis();
		waitTime = parent.random(5000) + 10000;
	}

	// -------------------------------------------------------------------------

    @Override
    public void move() { // like physObject move, but also check for ScoreZone
        super.move();
        collide(getWorld().getActors(ScoreZone.class).get(0));
    }

	private void makeNoise() {
		if (parent.millis() >= startTime + waitTime) {
			switch ((int)parent.random(8) + 1) {
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
				
			default:
				//do nothing, here so sonarQube stops whining
			}
			
			startTime = parent.millis();
			waitTime = parent.random(5000) + 11000;
		}
	}

	public void flee(){
		moving = true;
		velocity = PVector.sub(position, getWorld().player.position);
		velocity.normalize().mult(CATSPEED);
	}

	public void changeDir(){
		velocity = PVector.random2D();
		velocity.mult(CATSPEED);
	}//close changeDir

	public void alone(){
	int curSec = PApplet.second();

	if(curSec != lastSec){
		lastSec = curSec;
		
		if((int)(parent.random(CMC)) == 0){
			moving = !moving;
			if(moving){
				changeDir();
			}//close if moving
		}//close if changing move state
		
		if(moving && ((int)(parent.random(CDC)) == 0)){
				changeDir();
		}//close if moving
	}//close timing if

	}//close pathing

	public void pathing(){
		if(PApplet.dist(getWorld().player.position.x, getWorld().player.position.y, position.x, position.y) <= FLEERAD){
			flee();
		}else{
			alone();
		}
	}

	public void scoreCat() {
		getWorld().getScore().incrementCatsCorralled();
		markDelete();
	}
	
	@Override
	public void extraEffect(PhysObject obj) {
		if (obj instanceof BreakableObject) {
			((BreakableObject)obj).breakObject();
		}
		else if (obj instanceof ScoreZone) {
			scoreCat();
		}
	}

	@Override
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
