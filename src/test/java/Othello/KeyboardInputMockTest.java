package Othello;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Othello.KeyboardInput;
import Othello.Othello;
import Othello.KeyboardInputMock;

public class KeyboardInputMockTest {

	@Test
	public void integersCoordinatesTest() {
		
		Othello othello = new Othello();
		
		KeyboardInput input = new KeyboardInputMock();
		
		othello.setInput(input);
		
		othello.play();
		
	}

}
