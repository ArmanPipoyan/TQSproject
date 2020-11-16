package Othello;

import org.junit.Test;

public class BoardMockTest {
	
	@Test
	public void drawBoardMockTest() {
		Board drawBoardMock=new BoardMock();
		Othello othelloDraw = new Othello();
		othelloDraw.setBoard(drawBoardMock);
		othelloDraw.play(); 
	}

}
