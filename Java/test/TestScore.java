// William Elliott //

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Score;

public class TestScore {
	Score score;
	
	private game.CAT cat;
	
	@Before
	public void setup(){
		cat = new game.CAT();
	}
	
	@Test
	public void testIncrementObjectsBroken(){
		score = new Score(cat);
		score.incrementObjectsBroken(5);
		
		assertEquals(1, score.getNumObjects());
		assertEquals(-5, score.getObjectsValue());
	}//close TestIncrementObjectsBroken
	
	@Test
	public void testIncrementCatsCoralled(){
		score = new Score(cat);
		score.incrementCatsCorralled();
		
		assertEquals(1, score.getNumCats());
	}//close TestIncrementCatsCoralled

}
