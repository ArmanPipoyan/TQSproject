package Othello;

import org.junit.Test;
import static org.junit.Assert.*;

public class AutomatedTestGames {

	@Test
	//Uses keyboard input mock and realize Path Coverage
	public void integersCoordinatesTest() {	
		Othello whitePassBug = new Othello();
		KeyboardInput input1 = new AutomatedTestInputs(1);
		whitePassBug.setInput(input1);
		whitePassBug.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());

		Othello drawGame = new Othello();
		KeyboardInput input2 = new AutomatedTestInputs(2);
		drawGame.setInput(input2);
		drawGame.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());
		

		Othello notFullBoard = new Othello();
		KeyboardInput input3 = new AutomatedTestInputs(3);
		notFullBoard.setInput(input3);
		notFullBoard.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());
		
		Othello wipeOut = new Othello();
		KeyboardInput input4 = new AutomatedTestInputs(4);
		wipeOut.setInput(input4);
		wipeOut.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());
		
		Othello whiteWins = new Othello();
		KeyboardInput input5 = new AutomatedTestInputs(5);
		whiteWins.setInput(input5);
		whiteWins.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());

		Othello blackWins = new Othello();
		KeyboardInput input6 = new AutomatedTestInputs(6);
		blackWins.setInput(input6);
		blackWins.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());
	}
}
