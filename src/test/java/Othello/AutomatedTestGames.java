package Othello;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Ignore;

public class AutomatedTestGames {
	
	@Test(timeout=1000)
	public void whitePassBugTest() {	
		Othello whitePassBug = new Othello();
		KeyboardInput input1 = new AutomatedTestInputs(1);
		whitePassBug.setInput(input1);
		whitePassBug.play();
		assertTrue(whitePassBug.getGame().getGameBoard().isFull());
	}
	
	@Test()
	public void drawGameTest() {	
		Othello drawGame = new Othello();
		KeyboardInput input2 = new AutomatedTestInputs(2);
		drawGame.setInput(input2);
		drawGame.play();
		assertTrue(drawGame.getGame().getGameBoard().isFull());
	}
	
	@Test(timeout=1000)
	public void notFullBoardTest() {
		Othello notFullBoard = new Othello();
		KeyboardInput input3 = new AutomatedTestInputs(3);
		notFullBoard.setInput(input3);
		notFullBoard.play();
		assertTrue(notFullBoard.getGame().getGameBoard().isFull());
	}
	
	@Test(timeout=1000)
	public void wipeOutTest() {
		Othello wipeOut = new Othello();
		KeyboardInput input4 = new AutomatedTestInputs(4);
		wipeOut.setInput(input4);
		wipeOut.play();
		assertTrue(wipeOut.getGame().getGameBoard().isFull());
	}
	
	@Test()
	public void whiteWinsTest() {
		Othello whiteWins = new Othello();
		KeyboardInput input5 = new AutomatedTestInputs(5);
		whiteWins.setInput(input5);
		whiteWins.play();
		assertTrue(whiteWins.getGame().getGameBoard().isFull());
	}
	
	@Test()
	public void blackWinsTest() {
		Othello blackWins = new Othello();
		KeyboardInput input6 = new AutomatedTestInputs(6);
		blackWins.setInput(input6);
		blackWins.play();
		assertTrue(blackWins.getGame().getGameBoard().isFull());
	}
}
