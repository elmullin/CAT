package test;

public class TestScore {
	Score score;
	
	@Test
	public void TestIncrementObjectsBroken(){
		score = new Score();
		score.incrementObjectsBroken(5);
		
		assertEquals(1, score.getNumObjects());
		assertEquals(-5, score.getObjectsValue());
	}//close TestIncrementObjectsBroken
	
	@Test
	public void TestIncrementCatsCoralled(){
		score = new Score();
		score.incrementCatsCoralled();
		
		assertEquals(1, getNumCats());
	}//close TestIncrementCatsCoralled

}
