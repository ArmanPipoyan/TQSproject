package Othello;

public class MockBoard extends Board {
	
	public MockBoard(int numBoard) {
		if (numBoard == 1) {
			this.gameBoard = new Disk[8][8];
			this.gameBoard[0][3] = new Disk(Color.White);
			this.gameBoard[1][3] = new Disk(Color.Black);
			this.gameBoard[2][3] = new Disk(Color.Black);
			this.gameBoard[4][3] = new Disk(Color.Black);
			this.gameBoard[5][3] = new Disk(Color.Black);
			this.gameBoard[6][3] = new Disk(Color.Black);
			this.gameBoard[7][3] = new Disk(Color.Black);
			
			this.gameBoard[3][4] = new Disk(Color.Black);
			this.gameBoard[3][5] = new Disk(Color.Black);
			this.gameBoard[3][6] = new Disk(Color.Black);
			this.gameBoard[3][7] = new Disk(Color.Black);
			
			this.gameBoard[3][2] = new Disk(Color.Black);
			this.gameBoard[3][1] = new Disk(Color.White);
			
			this.gameBoard[4][2] = new Disk(Color.Black);
			this.gameBoard[5][1] = new Disk(Color.Black);
			this.gameBoard[6][0] = new Disk(Color.White);
			
			this.gameBoard[4][4] = new Disk(Color.Black);
			this.gameBoard[5][5] = new Disk(Color.Black);
			this.gameBoard[6][6] = new Disk(Color.Black);
			this.gameBoard[7][7] = new Disk(Color.White);
			
			this.gameBoard[2][2] = new Disk(Color.Black);
			this.gameBoard[1][1] = new Disk(Color.White);
			
			this.gameBoard[2][4] = new Disk(Color.Black);
			this.gameBoard[1][5] = new Disk(Color.Black);
			this.gameBoard[0][6] = new Disk(Color.White);
		}
		
		if (numBoard == 2) {
			this.gameBoard = new Disk[8][8];
			this.gameBoard[0][1] = new Disk(Color.White);
			this.gameBoard[0][2] = new Disk(Color.Black);
			
			this.gameBoard[1][0] = new Disk(Color.White);
			this.gameBoard[2][0] = new Disk(Color.White);
			this.gameBoard[3][0] = new Disk(Color.White);
			this.gameBoard[4][0] = new Disk(Color.White);
			this.gameBoard[5][0] = new Disk(Color.White);
			this.gameBoard[6][0] = new Disk(Color.Black);
			
			this.gameBoard[1][1] = new Disk(Color.White);
			this.gameBoard[2][2] = new Disk(Color.White);
			this.gameBoard[3][3] = new Disk(Color.White);
			this.gameBoard[4][4] = new Disk(Color.White);
			this.gameBoard[5][5] = new Disk(Color.White);
			this.gameBoard[6][6] = new Disk(Color.White);
			this.gameBoard[7][7] = new Disk(Color.Black);
		}
		if (numBoard == 3) {
			this.gameBoard = new Disk[8][8];
			this.gameBoard[0][3] = new Disk(Color.White);
			this.gameBoard[1][3] = new Disk(Color.White);
			
			this.gameBoard[2][3] = new Disk(Color.White);
			this.gameBoard[3][3] = new Disk(Color.White);//objetivo
			
			this.gameBoard[4][3] = new Disk(Color.Black);
			this.gameBoard[5][3] = new Disk(Color.Black);
			this.gameBoard[6][3] = new Disk(Color.Black);
			this.gameBoard[7][3] = new Disk(Color.Black);
			
			this.gameBoard[3][4] = new Disk(Color.Black);
			this.gameBoard[3][5] = new Disk(Color.Black);
			this.gameBoard[3][6] = new Disk(Color.Black);
			this.gameBoard[3][7] = new Disk(Color.Black);
			
			this.gameBoard[3][2] = new Disk(Color.White);
			this.gameBoard[3][1] = new Disk(Color.White);
			
			this.gameBoard[4][2] = new Disk(Color.White);
			this.gameBoard[5][1] = new Disk(Color.White);
			this.gameBoard[6][0] = new Disk(Color.White);
			
			this.gameBoard[4][4] = new Disk(Color.White);
			this.gameBoard[5][5] = new Disk(Color.White);
			this.gameBoard[6][6] = new Disk(Color.White);
			this.gameBoard[7][7] = new Disk(Color.White);
			
			this.gameBoard[2][2] = new Disk(Color.White);
			this.gameBoard[1][1] = new Disk(Color.White);
			
			this.gameBoard[2][4] = new Disk(Color.White);
			this.gameBoard[1][5] = new Disk(Color.White);
			this.gameBoard[0][6] = new Disk(Color.White);
		}
	}
}
