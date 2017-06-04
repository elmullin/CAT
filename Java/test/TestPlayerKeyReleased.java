/*
 * Dylan Kohler
 */

package test;

import org.junit.*;

public class TestPlayerKeyReleased {
   Player player;
   
   public TestPlayerKeyReleased() {
      player = new Player(null, 0, 0);
      player.pressKey('w');
      player.pressKey('a');
      player.pressKey('s');
      player.pressKey('d');
   }
   
   @Test
   public void testOneKeyPress() {
      int[] keysPressed = player.releaseKey('w');
      
      assertEquals(0, keysPressed[0]);
      assertEquals(-1, keysPressed[1]);
      assertEquals(1, keysPressed[2]);
      assertEquals(1, keysPressed[3]);
   }
   
   @Test
   public void testTwoKeyPress() {
      player.releaseKey('a');
      int[] keysPressed = player.releaseKey('s');
      
      assertEquals(-1, keysPressed[0]);
      assertEquals(0, keysPressed[1]);
      assertEquals(0, keysPressed[2]);
      assertEquals(1, keysPressed[3]);
   }
}