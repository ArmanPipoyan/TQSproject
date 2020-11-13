package Othello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	Disk[][] auxBoard;

	@Before
	public void setUp() throws Exception {
		board = new Board();
		auxBoard = board.getGameBoard();
	}

	@Test
	public void BoardConstructorTest() {
		
		for(int i=0; i<auxBoard.length; i++) {
			for(int j=0; j<auxBoard.length; j++) {
				if((i==3 && j==3) || (i==4 && j==4)) {
					assertEquals(Color.White, auxBoard[i][j].getColor());
				}
				else if ((i==3 && j==4) || (i==4 && j==3)) {
					assertEquals(Color.Black, auxBoard[i][j].getColor());
					}
				else {
					assertEquals(null, auxBoard[i][j]);
					}
			}
		}
	}
	
	@Test
	public void isFullTest() {
		board.setTotalWhites(25);
		board.setTotalBlacks(32);
		boolean res_25W_32B = board.isFull();
		assertFalse(res_25W_32B);
		
		board.setTotalWhites(32);
		board.setTotalBlacks(32);
		boolean res_32W_32B = board.isFull();
		assertTrue(res_32W_32B);
	}
	
	@Test
	public void updateScoreTest() {
		board.updateScore();
		assertEquals(2, board.getTotalBlacks());
		assertEquals(2, board.getTotalWhites());
		
	}
}
		
