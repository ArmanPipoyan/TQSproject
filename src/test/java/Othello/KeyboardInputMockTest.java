package Othello;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;

import org.junit.Before;
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
