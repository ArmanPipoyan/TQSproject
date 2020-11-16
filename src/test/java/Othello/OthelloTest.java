package Othello;

import static org.junit.Assert.*;

import org.junit.Test;

public class OthelloTest {

	@Test
	public void checkCoordinatesTest() {
		//Condition Coverage and Decision Coverage
		Othello othello = new Othello();
		assertFalse(othello.checkCoordinates(-1, -1)); //x=-1 and y=-1
		assertTrue(othello.checkCoordinates(-1, 3)); //x=-1 and y=3
		assertTrue(othello.checkCoordinates(5, -1)); //x=5 and y=-1  
		assertTrue(othello.checkCoordinates(4, 2)); //x=4 and y=2  
		
	}

}
