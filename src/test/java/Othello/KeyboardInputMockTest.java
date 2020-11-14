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
		KeyboardInput input = new KeyboardInputMock();
		Othello othello = new Othello();
		
		othello.setInput(input);
		
		othello.play();
		
	}

}
