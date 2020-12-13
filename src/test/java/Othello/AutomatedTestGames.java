package Othello;

import org.junit.Test;

public class AutomatedTestGames {

	@Test
	//Uses keyboard input mock and realize Path Coverage
	public void integersCoordinatesTest() {	
		Othello othelloWinBlacks = new Othello();
		KeyboardInput input1 = new AutomatedTestInputs();
		othelloWinBlacks.setInput(input1);
		othelloWinBlacks.play();
	}

}
