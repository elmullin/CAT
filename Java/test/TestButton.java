// CAT
// Group 1
// created by Erick Harris

package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Button;

public class TestButton {
	
	private static game.CAT cat;
	
	@Before
	public static void setup(){
		cat = new game.CAT();
	}

	@Test
	public void testButton1() {
		Button button1 = new Button(10, 10, 5, 5, cat);
		long[] output = new long[4];
		output[0] = button1.getPositionX();
		output[1] = button1.getPositionY();
		output[2] = button1.getRecHeight();
		output[3] = button1.getRecWidth();
		long[] expected = {10, 10, 5, 5};
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void testButton2() {
		Button button2 = new Button(20, 20, 20, 20, cat);
		long[] output = new long[3];
		output[0] = button2.getBackgroundColor(0);
		output[1] = button2.getBackgroundColor(1);
		output[2] = button2.getBackgroundColor(2);
		long[] expected = {77, 77, 77};
		assertArrayEquals(expected, output);
	}
	
}
