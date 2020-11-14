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
	
	public boolean outOfLimits(int row, int column) {
		return !((0 <= row && 0 <= column) && (row < gameBoard.length && column < gameBoard.length));
	}
	
	public boolean nextToDisk(int row, int column) {
		boolean nextTo = false;
	
		if (outOfLimits(row, column) == false ) {
			if (row-1 >= 0 && gameBoard[row-1][column] != null) {
				nextTo = true;
			}
			if (row+1 <= 7 && gameBoard[row+1][column] != null) {
				nextTo = true;
			}
			if (column-1 >= 0 && gameBoard[row][column-1] != null) {
				nextTo = true;
			}
			if (column+1 <= 7 && gameBoard[row][column+1] != null) {
				nextTo = true;
			}
			if (row+1 <= 7 &&column+1 <= 7 && gameBoard[row+1][column+1] != null) {
				nextTo = true;
			}
			if (row-1 >= 0 &&column-1 >= 0 && gameBoard[row-1][column-1] != null) {
				nextTo = true;
			}
			if (row+1 <=7 &&column-1 >= 0 && gameBoard[row+1][column-1] != null) {
				nextTo = true;
			}
			if (row-1 >= 0 &&column+1 <= 7 && gameBoard[row-1][column+1] != null) {
				nextTo = true;
			}
		}
		return nextTo;
	}
	
	public int positionsToSameColor(int row, int column, Color color, Direction dir){

	int row1 = 0;
	int col1 = 0;
			switch(dir) {
			case up:
				row1 = -1;
				break;
			case down:
				row1 = 1;
				break;
			case left:
				col1 = -1;
				break;
			case right:
				col1 = 1;
				break;
			case up_left_diagonal:
				row1 = -1;
				col1 = -1;
				break;
			case up_right_diagonal:
				row1 = -1;
				col1 = +1;
				break;
			case down_left_diagonal:
				row1 = +1;
				col1 = -1;
				break;
			case down_right_diagonal:
				row1 = +1;
				col1 = +1;
				break;
			}
			
			if (outOfLimits(row, column) || this.gameBoard[row][column] == null) {
				return -1;
			}
			
			if (this.gameBoard[row][column].getColor() == color) {
				return 0;
			}
			
			int check = positionsToSameColor(row + row1, column + col1, color, dir);
			if (check<0) {
				return -1;
			}
			
			this.gameBoard[row][column].changeColor();
			
			return check+1;
		}
	
	public boolean isFull() {
		return totalWhites + totalBlacks == 64;
	}
	
	@Override
	public String toString() {
		String board = "   A  B  C  D  E  F  G  H\n";
		for (int i = 0; i < gameBoard.length; i++) {
			board += ""+(i+1);
			for (int j = 0; j < gameBoard.length; j++) {
				if (gameBoard[i][j] == null) {
					board += "  -";
				} 
				else {
						if (gameBoard[i][j].getColor()==Color.Black) {
							board += "  B";
						}else {
							board += "  W";
						}
				}
			}
			board += "\n";
		}
		return board;
	}
}
