package Othello;

public class Board {

	private Disk[][] gameBoard;
	private int totalWhites;
	private int totalBlacks;
	
	public Board() {
		this.gameBoard = new Disk[8][8];
		this.gameBoard[3][3] = new Disk(Color.White);
		this.gameBoard[3][4] = new Disk(Color.Black);
		this.gameBoard[4][3] = new Disk(Color.Black);
		this.gameBoard[4][4] = new Disk(Color.White);
		
		this.totalBlacks = 2;
		this.totalWhites = 2;
	}
	
	public Disk[][] getGameBoard(){
		return gameBoard;
	}
	
	public int getTotalWhites() {
		return totalWhites;
	}
	
	public int getTotalBlacks() {
		return totalBlacks;
	}
	
	public void setTotalWhites(int nWhites) {
		totalWhites = nWhites;
	}
	
	public void setTotalBlacks(int nBlacks) {
		totalBlacks = nBlacks;
	}
	
	public void updateScore() {
		int countBlacks = 0;
		int countWhites = 0;
		for(int i=0; i<gameBoard.length; i++) {
			for(int j=0; j<gameBoard.length; j++) {
				if(gameBoard[i][j] != null) {
					if(gameBoard[i][j].getColor() == Color.Black) {
						countBlacks++;
					}else {
						countWhites++;
					}		
				}	
			}
		}
		totalBlacks = countBlacks;
		totalWhites = countWhites;
	}
	
	public boolean outOfLimits(int x, int y) {
		return true;
	}
	
	public boolean isFull() {
		return totalWhites + totalBlacks == 64;
	}
}
