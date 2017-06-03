public class BreakableObject extends PhysObject {

   private int value; // the cost of the object
   
   public BreakableObject(int value, PImage image, float posX, float posY, float radius) {
      super(image, posX, posY, radius, false);
      this.value = value;
   }

   /*
    * Called by a player or cat if they collide with this object
    */
   public void breakObject() {
      getWorld().score.incrementObjectsBroken(value);
      getWorld().removeActor(this);
   }
}