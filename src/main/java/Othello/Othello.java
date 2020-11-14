package Othello;

public class Othello{
	
	private static Game othello = new Game(); 
	static int playerTurn = 0;
	private static int coordinate_x;
	private static int coordinate_y;
	static KeyboardInput input = new KeyboardInput();
	private static Coordinate Valors = new Coordinate(coordinate_x, coordinate_y);

	
	public void play() {
		System.out.println("------------Othello------------");
		int totalWhites = othello.getGameBoard().getTotalWhites();
		int totalBlacks = othello.getGameBoard().getTotalBlacks();
		System.out.println("Black disks: "+totalBlacks+" White disks: "+totalWhites);
		System.out.println("");
		System.out.println(othello.getGameBoard());
		Color color;
		Player currentPlayer;
		while (othello.getGameBoard().isFull() == false) {
			currentPlayer =  BuscaJugador();
			color = BuscaColor(currentPlayer);
			
			System.out.println("Turn of Player: " + (playerTurn+1) + " ("+color+")");
			System.out.println("Input the cell where you can place the Disk (row, column): ");
			
			obtenerValors();
			System.out.println(coordinate_x+ ", " + coordinate_y);
			
			while(!checkCoordinates(coordinate_x, coordinate_y)) {
				System.out.println("Input the cell where you can place the Disk (row, column): ");
				obtenerValors();
				System.out.println(coordinate_x+ ", " + coordinate_y);
			}
			
			boolean disk = othello.getGameBoard().placeDisk(coordinate_x-1, coordinate_y-1, color);
			
			while(disk == false) {
				System.out.println("You can't place the disk here!");
				System.out.println("Input the cell where you can place the Disk (row, column): ");
				obtenerValors();
				System.out.println(coordinate_x+ ", " + coordinate_y);
				
				while(!checkCoordinates(coordinate_x, coordinate_y)) {
					System.out.println("Input the cell where you can place the Disk (row, column): ");
					obtenerValors();
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
		
		if (totalWhites < totalBlacks) {System.out.println("BLACKS WIN!");}
		else if (totalBlacks < totalWhites) { System.out.println("WHITES WIN!");}
		else {
			System.out.println("DRAW");
		}
	}
	
	public Color BuscaColor(Player currentPlayer) {
		if(currentPlayer.getColor().equals(Color.Black)==true)
			return Color.Black;
			else {
				return Color.White;
			}
	}
	
	public Player BuscaJugador() {
		return othello.getPlayer(playerTurn);
	}
	
	public boolean checkCoordinates(int x, int y)
	{
		if(x ==-1 || y == -1)
			return false;
		else {
			return true;
		}
	}
	public void obtenerValors() {
		Valors = input.integersCoordinates();
		coordinate_x = Valors.x;
		coordinate_y = Valors.y;
	}
	
	public void setInput(KeyboardInput input) {
		Othello.input = input;
	}

	public void changeTurn() {
		playerTurn += 1;
		if (playerTurn > 1) { playerTurn = 0; }
	}
	
}