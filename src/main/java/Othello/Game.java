package Othello;

public class Game {
	private Board board;
	private Player[] players;
	
	public Game() {
	this.board = new Board();
	this.players = new Player[2];
	this.players[0] =  new Player(Color.Black);
	this.players[1] = new Player(Color.White);
	}
	
	public Player getPlayer(int numPlayer) {
		return players[numPlayer];
	}
	
	public Board getGameBoard() {
		return board;
	}
	

}
