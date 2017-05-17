package game;

import processing.core.*;

public class Background extends PApplet{
    private PImage bg;
        
    public Background(String fileName){
        bg = loadImage("assets/" + fileName);
    }
        
    public void display(){
        image(bg, 0, 0);
        resetMatrix();
    }
}