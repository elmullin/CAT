/*
 * William Elliott 
 */

package test;

import org.junit.*;

public class TestPlayerKeyPressed {
   Player player;
   
   @Test
   public void testOneKeyPress() {
      player = new Player(null, 0, 0);
      int[] keysPressed = player.pressKey('w');
      
      assertEquals(-1, keysPressed[0]);
      assertEquals(0, keysPressed[1]);
      assertEquals(0, keysPressed[2]);
      assertEquals(0, keysPressed[3]);
   }
   
   @Test
   public void testTwoKeyPress() {
      player = new Player(null, 0, 0);
      player.pressKey('a');
      int[] keysPressed = player.pressKey('s');
      
      assertEquals(0, keysPressed[0]);
      assertEquals(-1, keysPressed[1]);
      assertEquals(1, keysPressed[2]);
      assertEquals(0, keysPressed[3]);
   }
}
