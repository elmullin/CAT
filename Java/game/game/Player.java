package game;

import processing.core.*; 

public class Player extends PhysObject {
   /*
    * Constants
    */
   private static final int MOVE_RATE = 1;
   private static final char UP = 'w';
   private static final char LEFT = 'a';
   private static final char DOWN = 's';
   private static final char RIGHT = 'd';

   /*
    * Fields
    */
   private int[] keysPressed;

   /**
    * Constructor. Creates a new object at the given location.
    */
   public Player(PImage sprite, int posX, int posY, PApplet p) {
      super(sprite, posX, posY, 0, 0, 1, true, p);
      parent = p;
      keysPressed = new int[4]; // holds pressed or not pressed state of W, A, S, D, respectively
   }

   // -------------------------------------------------------------------------
   /*
    * Overwrite default keyPressed() and keyReleased() to calculate new velocity vector
    * Called whenever a key is pressed or released, respectively
    */
   public int[] pressKey(char key) {
      System.out.println("Pressed " + key);
      if (UP == key) {
         keysPressed[0] = -1 * MOVE_RATE;
      }
      else if (LEFT == key) {
         keysPressed[1] = -1 * MOVE_RATE;
      }
      if (DOWN == key) {
         keysPressed[2] = MOVE_RATE;
      }
      if (RIGHT == key) {
         keysPressed[3] = MOVE_RATE;
      }
      return keysPressed;
   }

   public int[] releaseKey(char key) {
      System.out.println("Released " + key);
      if (UP == key) {
         keysPressed[0] = 0;
      }
      else if (LEFT == key) {
         keysPressed[1] = 0;
      }
      if (DOWN == key) {
         keysPressed[2] = 0;
      }
      if (RIGHT == key) {
         keysPressed[3] = 0;
      }
      return keysPressed;
   }

   // -------------------------------------------------------------------------

   private void calculateImageAngle() {
      PVector mouseVector = new PVector(parent.mouseX, parent.mouseY);
      mouseVector.sub(position);
      
      parent.pushMatrix();
         parent.rotate(mouseVector.heading());
         parent.translate(position.x, position.y);
         
         parent.image(getImage(), 0, 0);
      parent.popMatrix();
   }

   // -------------------------------------------------------------------------

   public void display() {
      velocity = new PVector(keysPressed[3] + keysPressed[1], keysPressed[2] + keysPressed[0]);
      //calculateImageAngle();
      super.display(); // TODO: delete this once fix rotation
      move();
      parent.resetMatrix();
   }
}