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
	public void testIsIntersecting() {
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
	public void testMove(){
		World world = new World(cat);
		TabbyCat a = new TabbyCat(null, 0, 0, null, cat);
		world.addActor(a);
		
		world.addActor(new TabbyCat(null, -1, 0, null, cat));
		
		a.velocity = new PVector(0, 1); // A is moving down
		a.move();
		
		assertEquals(11, a.position.x, 0.001);
		assertEquals(1, a.position.y, (float) 0.001);
	} // note: this can be repeated for more/fewer tabbycats, walls, etc.
}