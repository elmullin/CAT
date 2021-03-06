import ddf.minim.*;

public class Music {
	/*
	 * Fields
	 */
	private Minim minim;
	private AudioPlayer player;
		
	// -------------------------------------------------------------------------

	public Music(Minim minim, String track){
		this.minim = minim;
        player = minim.loadFile(track);
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