package Othello;

public class Board {

	private Disk[][] gameBoard;
	private int totalWhites;
	private int totalBlacks;
	
	public Board() {
		
	}
	
	public Disk[][] getGameBoard(){
		return gameBoard;
	}
}
