package Othello;

public class Othello{
	
	private Game othello; 
	private int playerTurn;
	private int coordinate_x;
	private int coordinate_y;
	private KeyboardInput input;

	public Othello() {
		othello = new Game();
		playerTurn = 0;
		input = new KeyboardInput();
	}
	
	public static void main(String[] args) {
		Othello othello = new Othello();
		othello.play();
	}

	public void play() {
		System.out.println("------------Othello------------#");
		
		int totalWhites = othello.getTotalWhites();
		int totalBlacks = othello.getTotalBlacks();
		Color color;
		System.out.println("");
		System.out.println(othello.getGameBoard());
		Player currentPlayer;
		
		while (othello.getGameBoard().isFull() == false) {
			currentPlayer = othello.getPlayer(playerTurn);
			color = currentPlayer.getColor().equals(Color.Black) ? Color.Black : Color.White;
			
			System.out.println("Turn of Player: " + (playerTurn+1) + " ("+color+")");
			System.out.println("Input the cell where you can place the Disk (row, column): ");
			coordinate_x = input.integersCoordinates().getX();
			coordinate_y = input.integersCoordinates().getY();
			
			while(coordinate_x ==-1 || coordinate_y == -1) {
				System.out.println("Input the cell where you can place the Disk (row, column): ");
				coordinate_x = input.integersCoordinates().getX();
				coordinate_y = input.integersCoordinates().getY();
			}
			
			boolean disk = othello.getGameBoard().placeDisk(coordinate_x-1, coordinate_y-1, color);
			
			while(disk == false) {
				System.out.println("You can't place the disk here!");
				System.out.println("Input the cell where you can place the Disk (row, column): ");
				coordinate_x = input.integersCoordinates().getX();
				coordinate_y = input.integersCoordinates().getY();
				
				while(coordinate_x ==-1 || coordinate_y == -1) {
					System.out.println("Input the cell where you can place the Disk (row, column): ");
					coordinate_x = input.integersCoordinates().getX();
					coordinate_y = input.integersCoordinates().getY();
				}
				disk = othello.getGameBoard().placeDisk(coordinate_x-1, coordinate_y-1, color);
			}
			changeTurn();
			totalWhites = othello.getTotalWhites();
			totalBlacks = othello.getTotalBlacks();
			System.out.println("Black disks: " + totalBlacks + " -  White disks: " + totalWhites);
			System.out.println("");
			System.out.println(othello.getGameBoard());
		}
		
		if (totalWhites < totalBlacks) {System.out.println("BLACKS WIN!");}
		else if (totalBlacks < totalWhites) { System.out.println("WHITES WIN!");}
		else {
			System.out.println("DRAW");
		}
	}
	
	public void setInput(KeyboardInput input) {
		this.input = input;
	}

	private void changeTurn() {
		playerTurn += 1;
		if (playerTurn > 1) { playerTurn = 0; }
	}
	
}