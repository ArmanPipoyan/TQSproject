package Othello;

public class Othello{
	
	private Game othello = new Game(); 
	private int playerTurn = 0;
	private int coordinate_x;
	private int coordinate_y;
	private KeyboardInput input = new KeyboardInput();
	

	
	public void play() {
		System.out.println("------------Othello------------");
		othello.getGameBoard().updateScore();
		int totalWhites = othello.getGameBoard().getTotalWhites();
		int totalBlacks = othello.getGameBoard().getTotalBlacks();
		System.out.println("Black disks: "+totalBlacks+" White disks: "+totalWhites);
		System.out.println("");
		System.out.println(othello.getGameBoard());
		Color color;
		Player currentPlayer;
		while (othello.getGameBoard().isFull() == false) {
			currentPlayer =  getCurrentPayer();
			color = getColor(currentPlayer);
			
			System.out.println("Turn of Player: " + (playerTurn+1) + " ("+color+")");
			System.out.println("Input the cell where you can place the Disk (row, column): ");
			
			getCoordinates();
			System.out.println(coordinate_x+ ", " + coordinate_y);
			
			while(!checkCoordinates(coordinate_x, coordinate_y)) {
				System.out.println("Input the cell where you can place the Disk (row, column): ");
				getCoordinates();
				System.out.println(coordinate_x+ ", " + coordinate_y);
			}
			
			boolean disk = othello.getGameBoard().placeDisk(coordinate_x-1, coordinate_y-1, color);
			
			while(disk == false) {
				System.out.println("You can't place the disk here!");
				System.out.println("Input the cell where you can place the Disk (row, column): ");
				getCoordinates();
				System.out.println(coordinate_x+ ", " + coordinate_y);
				
				while(!checkCoordinates(coordinate_x, coordinate_y)) {
					System.out.println("Input the cell where you can place the Disk (row, column): ");
					getCoordinates();
					System.out.println(coordinate_x+ ", " + coordinate_y);
				}
				disk = othello.getGameBoard().placeDisk(coordinate_x-1, coordinate_y-1, color);
			}
			changeTurn();
			totalWhites = othello.getGameBoard().getTotalWhites();
			totalBlacks = othello.getGameBoard().getTotalBlacks();
			System.out.println("Black disks: " + totalBlacks + " -  White disks: " + totalWhites);
			System.out.println("");
			System.out.println(othello.getGameBoard());
		}
		
		if (totalWhites < totalBlacks) {
			System.out.println("BLACKS WIN!");
		}
		else if (totalBlacks < totalWhites) { 
			System.out.println("WHITES WIN!");
			}
		else {
			System.out.println("DRAW");
		}
	}
	
	public Color getColor(Player currentPlayer) {
		if(currentPlayer.getColor().equals(Color.Black)==true)
			return Color.Black;
			else {
				return Color.White;
			}
	}
	
	public Player getCurrentPayer() {
		return othello.getPlayer(playerTurn);
	}
	
	public boolean checkCoordinates(int x, int y)
	{
		if(x ==-1 && y == -1)
			return false;
		else {
			return true;
		}
	}
	public void getCoordinates() {
		Coordinate cordinate = input.integersCoordinates();
		coordinate_x = cordinate.getX();
		coordinate_y = cordinate.getY();
	}
	
	//Added function
	public Game getGame() {
		return othello;
	}
	
	public void setInput(KeyboardInput input) {
		this.input = input;
	}
	
	public void setBoard(Board board) {
		othello.setGameBoard(board);
	}

	public void changeTurn() {
		playerTurn += 1;
		if (playerTurn > 1) { playerTurn = 0; }
	}
	
}