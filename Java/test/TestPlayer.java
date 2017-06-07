/*
 * Dylan Kohler
 */

package test;

import org.junit.*;
import game.*;

public class TestPlayerKeyReleased {
   Player player;
   
   public void setup() {
      player = new Player(null, 0, 0);
      player.pressKey('w');
      player.pressKey('a');
      player.pressKey('s');
      player.pressKey('d');
   }
   
   @Test
   public void testOneKeyPress() {
      setup();
      int[] keysPressed = player.releaseKey('w');
      
      assertEquals(0, keysPressed[0]);
   }
   
   @Test
   public void testTwoKeyPress() {
      setup();
      player.releaseKey('a');
      int[] keysPressed = player.releaseKey('s');
      
      assertEquals(0, keysPressed[2]);
   }
}