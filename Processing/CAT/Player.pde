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
   PImage sprite;

   /**
    * Constructor. Creates a new object at the given location.
    */
   public Player(int posX, int posY) {
      super(true, posX, posY);
      keysPressed = new int[4]; // holds pressed or not pressed state of W, A, S, D
      sprite = loadImage("assets/PlayerPlaceHolder.png");
   }

   // -------------------------------------------------------------------------
   /*
    * Overwrite default keyPressed() and keyReleased() to calculate new velocity vector
    * Called whenever a key is pressed or released, respectively
    */
   public void keyPressed() {
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
   }

   public void keyReleased() {
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
   }

   // -------------------------------------------------------------------------

   private void calculateVelocityAngle() {
      float tempAngle = atan((keysPressed[1] + keysPressed[3])/(keysPressed[0] + keysPressed[2]));
      
      if (keysPressed[1] + keysPressed[3] < 0) {
         tempAngle += HALF_PI;
         tempAngle = -1 * tempAngle;
      }
      
      setAngle(tempAngle);
   }

   private void calculateImageAngle() {
      PVector mouseVector = new PVector(mouseX, mouseY);
      PVector base = new PVector(1, 0);
      rotate(angleBetween(mouseVector, base));
   }

   // -------------------------------------------------------------------------

   public void display() {
      calculateVelocityAngle();
      calculateImageAngle();

      move();
      resetMatrix();
   }
}
