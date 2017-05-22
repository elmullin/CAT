import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;

public class Music{
    private Minim minim;
    private AudioPlayer aud;
        
    public Music(String fileName){
        minim = new Minim(this);
        aud = minim.loadFile("assets/" + fileName);
    }
    
    public void switchTrack(){
        //TODO
    }
}