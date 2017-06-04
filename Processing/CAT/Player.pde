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
   public Player(PImage sprite, int posX, int posY) {
      super(sprite, posX, posY, 0, 0, 1, true);
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

   private void calculateVelocity() {
      //float tempAngle;
      PVector newVelocity;
      /*System.out.println((keysPressed[1] + keysPressed[3]));
      if (0 != keysPressed[0] + keysPressed[2]) {
         tempAngle = atan((keysPressed[1] + keysPressed[3])/(keysPressed[0] + keysPressed[2]));
         if (keysPressed[1] + keysPressed[3] < 0) {
            tempAngle = -1 * tempAngle;
         }
      }
      else {
         tempAngle = 0;
      }*/
      newVelocity = new PVector(keysPressed[3] + keysPressed[1], keysPressed[2] + keysPressed[0]);
      setVelocity(newVelocity);
   }

   private void calculateImageAngle() {
      PVector mouseVector = new PVector(mouseX, mouseY);
      mouseVector.sub(position);
      
      pushMatrix();
         rotate(mouseVector.heading());
         super.display();
      popMatrix();
   }

   // -------------------------------------------------------------------------

   public void display() {
      calculateVelocity();
      calculateImageAngle();

      move();
      //resetMatrix();
   }
}