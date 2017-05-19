package game;

import processing.core.*;

public class Player extends PhysObject {
   /*
    * Fields
    */
   private double angle;

   /**
    * Constructor. Creates a new object at the given location.
    */
   public Player(int posX, int posY) {
      super(posX, posY);
      angle = 0;
   }

   // -------------------------------------------------------------------------

   private void calculateAngle() {
      double tempAngle = tan((mouseY - position.y)/(mouseX-position.x));
      while (tempAngle < 0) {
         tempAngle += TWO_PI;
      }
      while (tempAngle > TWO_PI) {
         tempAngle -= TWO_PI;
      }
      angle = addAngle(tempAngle);
   }

   private void calculateMovement() {

   }

   public void draw() {
      // calculate new angle based on mouse location
      calculateAngle();
      calculateMovement();
   }
}
