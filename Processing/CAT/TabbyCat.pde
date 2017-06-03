public class TabbyCat extends PhysObject {
   /*
    * Constants
    */
   private static final String SOUND_1 = "assets/Cat_Meow_1.mp3"
   private static final String SOUND_2 = "assets/Cat_Meow_2.mp3"
   private static final String SOUND_3 = "assets/Cat_Meow_3.mp3"
   private static final String SOUND_4 = "assets/Cat_Meow_4.mp3"
   private static final String SOUND_5 = "assets/Cat_Meow_5.mp3"
   private static final String SOUND_6 = "assets/Cat_Meow_6.mp3"
   private static final String SOUND_7 = "assets/Cat_Meow_7.mp3"
   private static final String SOUND_8 = "assets/Cat_Purr_1.mp3"


   /*
    * Fields
    */
   private Music catSounds;
   private int startTime;
   private int waitTime;


   // -------------------------------------------------------------------------

   public TabbyCat(PImage image, int x, int y){
      super(image, true, x, y);
      catSounds = new Music();
      markTime = millis();
      waitTime = random(5000) + 10000;
   }

   // -------------------------------------------------------------------------
   private void makeNoise() {
      if (millis() >= startTime + waitTime) {
         switch (rng.nextInt(8) + 1) {
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
   
   //override collide for breakable object
   public void collide(BreakableObject broke){
     super(broke);
     broke.breakObject();
   }
   
   //override collide for ScoreZones
   public void collide(ScoreZone goal){
     super(goal);
     goal.scoreCat(this);
   }

   public void display() {
      makeNoise();
   }
}