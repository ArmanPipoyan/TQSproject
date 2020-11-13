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
	
	@Test
	public void outOfLimitsTest() {
		//position out of board next to corners
		assertFalse(board.outOfLimits(0, -1));
		assertFalse(board.outOfLimits(-1, -1));
		assertFalse(board.outOfLimits(-1, 7));
		assertFalse(board.outOfLimits(0, 8));
		assertFalse(board.outOfLimits(-1, 8));
		assertFalse(board.outOfLimits(8, 0));
		assertFalse(board.outOfLimits(7, -1));
		assertFalse(board.outOfLimits(8, -1));
		assertFalse(board.outOfLimits(7, 8));
		assertFalse(board.outOfLimits(8, 7));
		assertFalse(board.outOfLimits(8, 8));	
		
		//position in corners
		assertTrue(board.outOfLimits(0, 0));
		assertTrue(board.outOfLimits(0, 7));
		assertTrue(board.outOfLimits(7, 0));
		assertTrue(board.outOfLimits(7, 7));
		
		//position out of board next to laterals
		assertFalse(board.outOfLimits(-3, 0));
		assertFalse(board.outOfLimits(0, -3));
		assertFalse(board.outOfLimits(12, 0));
		assertFalse(board.outOfLimits(0, 9));
		assertFalse(board.outOfLimits(7, -3));
		assertFalse(board.outOfLimits(-3, 7));
		assertFalse(board.outOfLimits(7, 11));
		assertFalse(board.outOfLimits(9, 7));
		
		//position in laterals
		assertTrue(board.outOfLimits(0, 3));
		assertTrue(board.outOfLimits(3, 0));
		assertTrue(board.outOfLimits(7, 3));
		assertTrue(board.outOfLimits(3, 7));
		
		//position out of board with row or column in central cells
		assertFalse(board.outOfLimits(10, -3));
		assertFalse(board.outOfLimits(-5, 7));
		assertFalse(board.outOfLimits(-0, 11));
		assertFalse(board.outOfLimits(-4, 9));
		assertFalse(board.outOfLimits(7, -3));
		assertFalse(board.outOfLimits(10, -3));
		assertFalse(board.outOfLimits(9, 7));
		
		//position with all coordinates out of board
		assertFalse(board.outOfLimits(-2, -4));
		assertFalse(board.outOfLimits(9, 10));
		
		
	}
	
}
		
