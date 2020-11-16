package Othello;

public class BoardMock extends Board {
	
	public BoardMock() {
		gameBoard = new Disk[8][8];
		
		for (int i=0; i<4; i++) {
			for (int j= 0; j<gameBoard.length; j++) {
				gameBoard[i][j] = new Disk(Color.Black);
			}
		}
		
		for (int i=4; i<8; i++) {
			for (int j= 0; j<gameBoard.length; j++) {
				gameBoard[i][j] = new Disk(Color.White);
			}
		}	
	}					
}
