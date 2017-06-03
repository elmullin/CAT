import ddf.minim.*;

public class Music {
   /*
    * Constants
    */
   private static final String TITLE = "assets/Adventure Meme.mp3";
   private static final String MENU = "assets/Who Likes to Party.mp3";
   private static final String LEVEL = "assets/Covert Affair.mp3";

   /*
    * Fields
    */
   private Minim minim;
   private AudioPlayer player;
        
   // -------------------------------------------------------------------------

   public Music(){
      minim = new Minim(this);
      player = minim.loadFile(TITLE);
      player.play();
      player.loop();
      curSong = TITLE;
   }

   // -------------------------------------------------------------------------

   /*
    * Switches the music track to the specified track
    */
   public void switchTrack(String track, boolean loop){
      player = minim.loadFile(track);
      player.play();
      if (loop) {
         player.loop();
      }
   }
}
