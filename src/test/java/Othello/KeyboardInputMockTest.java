package Othello;

import org.junit.Test;


public class KeyboardInputMockTest {

	@Test
	//Uses keyboard input mock and helps to do Statement Coverage
	public void integersCoordinatesTest() {	
		Othello othelloWinBlacks = new Othello();
		KeyboardInput input1 = new KeyboardInputMock(1);
		othelloWinBlacks.setInput(input1);
		othelloWinBlacks.play();
		
		Othello othelloWinWhites = new Othello();
		KeyboardInput input2 = new KeyboardInputMock(2);
		othelloWinWhites.setInput(input2);
		othelloWinWhites.play();
		
	}

}
