package Othello;

public class Board {

	private Disk[][] gameBoard;
	private int totalWhites;
	private int totalBlacks;
	
	public Board() {
		this.gameBoard = new Disk[8][8];
	}
	
	public Disk[][] getGameBoard(){
		return gameBoard;
	}
}
