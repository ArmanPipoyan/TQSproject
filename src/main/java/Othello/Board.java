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
	}
	
	public Disk[][] getGameBoard(){
		return gameBoard;
	}
}
