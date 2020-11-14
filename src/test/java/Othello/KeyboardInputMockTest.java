package Othello;

import org.junit.Test;


public class KeyboardInputMockTest {

	@Test
	public void integersCoordinatesTest() {	
		
		Othello othello = new Othello();
		
		KeyboardInput input = new KeyboardInputMock();
		
		othello.setInput(input);
		
		othello.play();
		
	}

}
