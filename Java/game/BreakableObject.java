package game;

import processing.core.*;

public class BreakableObject extends PhysObject {
   /*
    * Fields
    */
   private int value;

   // -------------------------------------------------------------------------

   public BreakableObject(int value, int posx, int posy) {
      super(false, posx, posy);
      this.value = value;
   }

   // -------------------------------------------------------------------------


   public void display() {
      //TODO: set the image
   }


// ----------------------------------------------------------------------------

   /*
    * Called by a player or cat if they collide with this object
    */
   public void breakObject() {
      world.score.incrementObejctsBroken(value);
      world.remove(this);
   }
}
