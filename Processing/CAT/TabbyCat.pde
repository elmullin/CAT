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

	private static final int CATSPEED = 2; //speed of cats movement per frame
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

	public TabbyCat(PImage image, float x, float y, Minim minim){
		super(image, x, y, 0, 0, 20, true);
		catSounds = new Music(minim);
		startTime = millis();
		waitTime = random(5000) + 10000;
	}

	// -------------------------------------------------------------------------
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

	public void changeDir(){
   	velocity = PVector.random2D();
   	velocity.mult(CATSPEED);
	}//close changeDir

	public void pathing(){
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
	
	//override collide for breakable object BROKEN?
	public void collide(BreakableObject broke){
		super.collide(broke);
		broke.breakObject();
	}
	
	//override collide for ScoreZones BROKEN?
	public void collide(ScoreZone goal){
		super.collide(goal);
		goal.scoreCat(this);
	}//close collide ScoreZone

	public void display() {
   	pathing();
   	move();
		super.display();
		makeNoise();
	}//close display
}