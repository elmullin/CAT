import ddf.minim.*;

public class Music {
   /*
    * Fields
    */
   private Minim minim;
   private AudioPlayer player;
        
   // -------------------------------------------------------------------------

   public Music(){
      minim = new Minim(this);
   }

   // -------------------------------------------------------------------------

   /*
    * Switches the music track to the specified track
    */
   public void switchTrack(String track, boolean loop){
      System.out.println(track);
      player = minim.loadFile(track);
      player.play();
      if (loop) {
         player.loop();
      }
   }
}