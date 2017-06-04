package game;

import processing.core.*;
import ddf.minim.*;

public class CAT extends PApplet{

   private World world;
   private Minim minim;

   PImage catgif;
   PImage bg;
   PImage playerImg;

   Player player;

   public void setup(){
      minim = new Minim(this);
      LevelBuilder levelBuilder = new LevelBuilder();
      // -- load images --
      catgif = loadImage("/assets/cat.gif");
      bg = loadImage("/assets/bg.png");
      playerImg = loadImage("/assets/PlayerPlaceHolder.png");
   
      world = levelBuilder.buildWorld(minim, catgif, bg, playerImg);
   
      player = (Player)(world.getActors(Player.class).get(0));
   }

   public void draw(){
      imageMode(CENTER);
      world.display();
   }

   public void settings(){
      size(800, 600);
   }

   public void keyPressed() {
      player.pressKey(key);
   }

   public void keyReleased() {
      player.releaseKey(key);
   }
}
