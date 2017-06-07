/*
 * Zoe Cagle
 */
 
package test;

import static org.junit.Assert.*;

import org.junit.*;

import processing.core.*;
import game.*;

public class TestPhysObject {
	
	private game.CAT cat;
	
	@Before
	public void setup(){
		cat = new game.CAT();
	}
	
	@Test
	public void testIsIntersecting(){
		TabbyCat a = new TabbyCat(null, 0, 0, null, cat);
		TabbyCat b = new TabbyCat(null, 0, 0, null, cat);
		assertEquals(true, a.isIntersecting(b));
		
		b = new TabbyCat(null, 12, 0, null, cat);
		assertEquals(true, a.isIntersecting(b));
		
		b = new TabbyCat(null, -12, 0, null, cat);
		assertEquals(true, a.isIntersecting(b));
		
		b = new TabbyCat(null, 24, 0, null, cat);
		assertEquals(false, a.isIntersecting(b));
		
		b = new TabbyCat(null, -24, 0, null, cat);
		assertEquals(false, a.isIntersecting(b));
		
		b = new TabbyCat(null, 36, 0, null, cat);
		assertEquals(false, a.isIntersecting(b));
		
		b = new TabbyCat(null, -36, 0, null, cat);
		assertEquals(false, a.isIntersecting(b));
		
	}
	
   @Test
   public void testMove0Actors(){ // tests the three loops in move
      World world = new World(cat);
      Player a = new Player(null, 0, 0, null, cat);
      world.addActor(a);
      a.pressKey('w');

      a.move();
      assertEquals(-1 player.getPosition().y, .001);
   }

	@Test
	public void testMove1(){ // tests the three loops in move
		World world = new World(cat);
		Player a = new Player(null, 0, 0, null, cat);
		world.addActor(a);
      a.pressKey('w');

      world.addWall(new Wall(-100, -1, 100, -20));
		
		world.addActor(new TabbyCat(null, -1, 0, null, cat));

      world.addActor(new BreakableObject(400, null, 0, 1, 0, cat));
		
		a.move();
		
		assertEquals(0, a.getPosition().y, 0.001);
	} 

   @Test
   public void testMove2(){ // tests the three loops in move
		World world = new World(cat);
		Player a = new Player(null, 0, 0, null, cat);
		world.addActor(a);
      a.pressKey('w');

      world.addWall(new Wall(-100, -1, 100, -20));
      world.addWall(new Wall(-100, 1, 100, 20));
		
		world.addActor(new TabbyCat(null, -1, 0, null, cat));
      world.addActor(new TabbyCat(null, 1, 0, null, cat));

      world.addActor(new BreakableObject(400, null, 1, 0, 0, cat));
      world.addActor(new BreakableObject(400, null, 2, 0, 0, cat));
		
		a.move();
		
		assertEquals(0, a.getPosition().y, 0.001);

   }

   @Test
   public void testMove10(){ // tests the three loops in move a typical number of times
		World world = new World(cat);
		Player a = new Player(null, 0, 0, null, cat);
		world.addActor(a);
      a.pressKey('w');

      for (int i = 0; i < 10; i++) {
         world.addWall(new Wall(-100, -1 + -20 * i, 100, -21 + -20 * i));
      }
		
      for (int i = 0; i < 10; i++) {
		   world.addActor(new TabbyCat(null, -1 * i, 0, null, cat));
      }

      for (int i = 0; i < 10; i++) {
         world.addActor(new BreakableObject(400, null, 1 * i, 0, 0, cat));
      }
		
		a.move();
		
		assertEquals(0, a.getPosition().y, 0.001);
   }
}
