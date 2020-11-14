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
		assertTrue(board.outOfLimits(0, -1));
		assertTrue(board.outOfLimits(-1, -1));
		assertTrue(board.outOfLimits(-1, 7));
		assertTrue(board.outOfLimits(0, 8));
		assertTrue(board.outOfLimits(-1, 8));
		assertTrue(board.outOfLimits(8, 0));
		assertTrue(board.outOfLimits(7, -1));
		assertTrue(board.outOfLimits(8, -1));
		assertTrue(board.outOfLimits(7, 8));
		assertTrue(board.outOfLimits(8, 7));
		assertTrue(board.outOfLimits(8, 8));	
		
		//position in corners
		assertFalse(board.outOfLimits(0, 0));
		assertFalse(board.outOfLimits(0, 7));
		assertFalse(board.outOfLimits(7, 0));
		assertFalse(board.outOfLimits(7, 7));
		
		//position out of board next to laterals
		assertTrue(board.outOfLimits(-3, 0));
		assertTrue(board.outOfLimits(0, -3));
		assertTrue(board.outOfLimits(12, 0));
		assertTrue(board.outOfLimits(0, 9));
		assertTrue(board.outOfLimits(7, -3));
		assertTrue(board.outOfLimits(-3, 7));
		assertTrue(board.outOfLimits(7, 11));
		assertTrue(board.outOfLimits(9, 7));
		
		//position in laterals
		assertFalse(board.outOfLimits(0, 3));
		assertFalse(board.outOfLimits(3, 0));
		assertFalse(board.outOfLimits(7, 3));
		assertFalse(board.outOfLimits(3, 7));
		
		//position out of board with row or column in central cells
		assertTrue(board.outOfLimits(10, -3));
		assertTrue(board.outOfLimits(-5, 7));
		assertTrue(board.outOfLimits(-0, 11));
		assertTrue(board.outOfLimits(-4, 9));
		assertTrue(board.outOfLimits(7, -3));
		assertTrue(board.outOfLimits(10, -3));
		assertTrue(board.outOfLimits(9, 7));
		
		//position with all coordinates out of board
		assertTrue(board.outOfLimits(-2, -4));
		assertTrue(board.outOfLimits(9, 10));
		
		
	}
	
	@Test
	public void nextToDiskTest() {
		//Only let the disk be placed if there is an opponent next to it
				System.out.println(board);

				//positions where you should let black disks
				assertTrue(board.nextToDisk(2, 3));
				assertTrue(board.nextToDisk(3, 2));
				assertTrue(board.nextToDisk(4, 5));
				assertTrue(board.nextToDisk(5, 4));
				
				//corners can also be placed
				assertTrue(board.nextToDisk(2, 2));
				assertTrue(board.nextToDisk(5, 5));
				
				//limit positions
				assertFalse(board.nextToDisk(0, 0));
				assertFalse(board.nextToDisk(0, 1));
				assertFalse(board.nextToDisk(0, 2));
				assertFalse(board.nextToDisk(0, 3));
				assertFalse(board.nextToDisk(0, 4));
				assertFalse(board.nextToDisk(0, 5));
				assertFalse(board.nextToDisk(0, 6));
				assertFalse(board.nextToDisk(0, 7));
				
				//
				assertFalse(board.nextToDisk(1, 0));
				assertFalse(board.nextToDisk(2, 0));
				assertFalse(board.nextToDisk(3, 0));
				assertFalse(board.nextToDisk(4, 0));
				assertFalse(board.nextToDisk(5, 0));
				assertFalse(board.nextToDisk(6, 0));
				assertFalse(board.nextToDisk(7, 0));
				
				//
				assertFalse(board.nextToDisk(0, 7));
				assertFalse(board.nextToDisk(1, 7));
				assertFalse(board.nextToDisk(2, 7));
				assertFalse(board.nextToDisk(3, 7));
				assertFalse(board.nextToDisk(4, 7));
				assertFalse(board.nextToDisk(5, 7));
				assertFalse(board.nextToDisk(6, 7));
				assertFalse(board.nextToDisk(7, 7));
				
				//
				assertFalse(board.nextToDisk(7, 0));
				assertFalse(board.nextToDisk(7, 1));
				assertFalse(board.nextToDisk(7, 2));
				assertFalse(board.nextToDisk(7, 3));
				assertFalse(board.nextToDisk(7, 4));
				assertFalse(board.nextToDisk(7, 5));
				assertFalse(board.nextToDisk(7, 6));
				assertFalse(board.nextToDisk(7, 7));

	
	}
	
	@Test
	public void positionsToSameColorTest() {
		
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.down));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.down_left_diagonal));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.left));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.right));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.down_right_diagonal));
		
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.down));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.down_left_diagonal));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.left));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.right));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.down_right_diagonal));
		
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.down));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.down_left_diagonal));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.left));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.right));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.down_right_diagonal));
		
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.down));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.down_left_diagonal));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.left));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.right));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.down_right_diagonal));
		
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.down));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.down_left_diagonal));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.left));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.right));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.down_right_diagonal));
		
		assertEquals(-1, board.positionsToSameColor(5, 2, Color.Black, Direction.up_right_diagonal));
	}
	
	
}
		
