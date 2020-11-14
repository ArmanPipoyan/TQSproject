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
		//Score at initial state 
		board.updateScore();
		assertEquals(2, board.getTotalBlacks());
		assertEquals(2, board.getTotalWhites());
		
		//Score after fail placing disk attempt  
		board.placeDisk(1, 1, Color.Black);
		board.updateScore();
		assertEquals(2, board.getTotalBlacks());
		assertEquals(2, board.getTotalWhites());
		
		//Score after correct placing disk attempt  
		board.placeDisk(2, 3, Color.Black);
		board.updateScore();
	    assertEquals(4, board.getTotalBlacks());
		assertEquals(1, board.getTotalWhites());
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
		
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.down, false));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.down_left_diagonal, false));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.left, false));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.right, false));
		assertEquals(-1, board.positionsToSameColor(2, 3, Color.White, Direction.down_right_diagonal, false));
		
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.down, false));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.down_left_diagonal, false));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.left, false));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.right, false));
		assertEquals(-1, board.positionsToSameColor(2, 2, Color.White, Direction.down_right_diagonal, false));
		
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.down, false));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.down_left_diagonal, false));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.left, false));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.right, false));
		assertEquals(-1, board.positionsToSameColor(2, 5, Color.White, Direction.down_right_diagonal, false));
		
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.down, false));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.down_left_diagonal, false));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.left, false));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.right, false));
		assertEquals(-1, board.positionsToSameColor(2, 1, Color.White, Direction.down_right_diagonal, false));
		
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.down, false));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.down_left_diagonal, false));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.left, false));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.right, false));
		assertEquals(-1, board.positionsToSameColor(4, 2, Color.White, Direction.down_right_diagonal, false));
		
		assertEquals(-1, board.positionsToSameColor(5, 2, Color.Black, Direction.up_right_diagonal, false));
	}
	
	@Test
	public void checkPlaceDiskTest(){
		
		////positions where we can place a white disk but we can't place a black disk
		assertFalse(board.checkPlaceDisk(4, 2, Color.Black, false));
		assertFalse(board.checkPlaceDisk(5, 3, Color.Black, false));
		assertFalse(board.checkPlaceDisk(2, 4, Color.Black, false));
		assertFalse(board.checkPlaceDisk(3, 5, Color.Black, false));
		
		//positions next to white disk but on lines it doesn't have another disk of the same color to meet the condition 
		assertFalse(board.checkPlaceDisk(5, 2, Color.Black, false));
		assertFalse(board.checkPlaceDisk(2, 5, Color.Black, false));
		
		//position where we can put a black disk
		assertTrue(board.checkPlaceDisk(2, 3, Color.Black, false));
		assertTrue(board.checkPlaceDisk(3, 2, Color.Black, false));
		assertTrue(board.checkPlaceDisk(4, 5, Color.Black, false));
		assertTrue(board.checkPlaceDisk(5, 4, Color.Black, false));
		
		//positions where we can place a black disk but we can't place a white disk
		assertFalse(board.checkPlaceDisk(2, 3, Color.White, false));
		assertFalse(board.checkPlaceDisk(3, 2, Color.White, false));
	    assertFalse(board.checkPlaceDisk(4, 5, Color.White, false));
	    assertFalse(board.checkPlaceDisk(5, 4, Color.White, false));
				
		//positions next to black disk but on lines it doesn't have another disk of the same color to meet the condition 
		assertFalse(board.checkPlaceDisk(2, 2, Color.White, false));
		assertFalse(board.checkPlaceDisk(5, 5, Color.White, false));
		
		//position where we can put a white disk
		assertTrue(board.checkPlaceDisk(4, 2, Color.White, false));
		assertTrue(board.checkPlaceDisk(5, 3, Color.White, false));
		assertTrue(board.checkPlaceDisk(2, 4, Color.White, false));
		assertTrue(board.checkPlaceDisk(3, 5, Color.White, false));
		
	}
	
	@Test
	public void placeDiskTest(){
		
		//we add a black disk in a position where we can't.
		assertFalse(board.placeDisk(3, 3, Color.Black));
		assertFalse(board.placeDisk(2, 2, Color.Black));
		
		//We add a Black disk in a position where we can and check the changes that are made on the board.
		assertTrue(board.placeDisk(2, 3, Color.Black));
		assertNotEquals(Color.White, auxBoard[3][3].getColor());
		assertEquals(Color.Black, auxBoard[2][3].getColor());
		assertEquals(Color.Black, auxBoard[3][3].getColor());
		
		//we add a white disk in a position where we can't.
		assertFalse(board.placeDisk(3, 3, Color.White));
		assertFalse(board.placeDisk(2, 3, Color.White));
		
		//We add a Black disk in a position where we can and check the changes that are made on the board.
		assertTrue(board.placeDisk(2, 2, Color.White));
		assertNotEquals(Color.Black, auxBoard[3][3].getColor());
		assertEquals(Color.White, auxBoard[2][2].getColor());
		assertEquals(Color.White, auxBoard[3][3].getColor());
	
	}
		
}
		
