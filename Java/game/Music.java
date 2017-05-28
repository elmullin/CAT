package game;

import processing.core.PApplet;
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
   private String curSong;
        
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
    * 
    * track = "title" - switches to TITLE
    * track = "menu" - switches to MENU
    * track = "level" - switches to LEVEL
    *
    * If the function returns without changing the song, either the song specified
    * in track is already playing or track is an invalid string
    */
   public void switchTrack(String track){
      if (track.equals(curSong)) {
         return;
      }

      if (track.equals("title")) {
         player = minim.loadFile(TITLE);
      }
      else if (track.equals("menu")) {
         player = minim.loadFile(MENU);
      }
      else if (track.equals("level")) {
         player = minim.loadFile(LEVEL);
      }
      else {
         return;
      }

      player.play();
      player.loop();
      curSong = track;
   }
}
