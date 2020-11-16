package Othello;

public class Board {

	protected Disk[][] gameBoard;
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
		return this.gameBoard;
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
	
	private boolean outOfLimits(int row, int column) {
		return !((0 <= row && 0 <= column) && (row < gameBoard.length && column < gameBoard.length));
	}
	
	public boolean proxyoutOfLimits(int row, int column) {
		return outOfLimits(row, column);
	}
	
	private boolean nextToDisk(int row, int column) {
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
	
	public boolean proxynextToDisk(int row, int column) {
		return nextToDisk(row, column);
	}
	
	private int positionsToSameColor(int row, int column, Color color, Direction direction, boolean turn){
		
	int row1 = 0;
	int col1 = 0;
	Coordinate coordinate = checkDirection(row1, col1, direction);
	row1 = coordinate.x;
	col1 = coordinate.y;
				
			if (outOfLimits(row, column) || gameBoard[row][column] == null) {
				return -1;
			}
			
			if (gameBoard[row][column].getColor() == color) {
				return 0;
			}
			
			int check = positionsToSameColor(row + row1, column + col1, color, direction, turn);
			if (check<0) {
				return -1;
			}
			if(turn == true) {
				gameBoard[row][column].changeColor();
			}
			return check+1;
		}
	
	public int proxypositionsToSameColor(int row, int column, Color color, Direction direction, boolean turn) {
		return positionsToSameColor(row, column, color, direction, turn);
	}
	
	private boolean checkPlaceDisk(int row, int column, Color color, boolean turn) {
		boolean canPlace = false;
		boolean nextToDisk = nextToDisk(row, column);
			
			if(nextToDisk == true){
				//Up
				if(!outOfLimits(row-1, column)==true
						&& gameBoard[row-1][column] != null){
					if(gameBoard[row-1][column].getColor() != color)  {
						canPlace = true;
					}
				}
				//Down	
			    if(!outOfLimits(row+1, column)==true
			    		&& gameBoard[row+1][column] != null ) {
					if(gameBoard[row+1][column].getColor() != color)  {
						canPlace = true;
					}
			    }
				//Left
			    if(!outOfLimits(row, column-1) == true
			    	&& gameBoard[row][column-1] != null) {
			 
					if(gameBoard[row][column-1].getColor() != color)  {
						canPlace = true;
					}
			    }
			    //Right
			    if(!outOfLimits(row, column+1)==true
			       && gameBoard[row][column+1] != null) {
					if(gameBoard[row][column+1].getColor() != color)  {
						canPlace = true;
					}
				}
			    //Down Left Diagonal
			    if(!outOfLimits(row+1, column-1)==true
			    	&& gameBoard[row+1][column-1] != null){
			    	
					if(gameBoard[row+1][column-1].getColor() != color)  {
						canPlace = true;
					}
				}
			    //Down Right Diagonal
			    if(!outOfLimits(row+1, column+1)==true
			    		&& gameBoard[row+1][column+1] != null) {
					if(gameBoard[row+1][column+1].getColor() != color)  {
						canPlace = true;
					}
				}
			    //Up Left Diagonal
			    if(!outOfLimits(row-1, column-1)==true
			    		&& gameBoard[row-1][column-1] != null) {
					if(gameBoard[row-1][column-1].getColor() != color)  {
						canPlace = true;
					}
				}
			    //Up Right Diagonal
			    if(!outOfLimits(row-1, column+1)==true
			    		&& gameBoard[row-1][column+1] != null) {
					if(gameBoard[row-1][column+1].getColor() != color)  {
						canPlace = true;
					}
				}
			}
			
			if (canPlace) {
				int cells [] = new int[8];
				cells[0] = positionsToSameColor(row-1, column, color, Direction.up, turn);
				cells[1] = positionsToSameColor(row+1, column, color, Direction.down, turn);
				cells[2] = positionsToSameColor(row, column-1, color, Direction.left, turn);
				cells[3] = positionsToSameColor(row, column+1, color, Direction.right, turn);
				cells[4] = positionsToSameColor(row-1, column-1, color, Direction.up_left_diagonal, turn);
				cells[5] = positionsToSameColor(row-1, column+1, color, Direction.up_right_diagonal, turn);
				cells[6] = positionsToSameColor(row+1, column-1, color, Direction.down_left_diagonal, turn);
				cells[7] = positionsToSameColor(row+1, column+1, color, Direction.down_right_diagonal, turn);
				
				int check = countCellstoDisk(cells);
				
				if (check <= 0) {
					canPlace = false;
				}
				else {
					canPlace = true;
				}
			}

			return canPlace;
	
	}
	
	public boolean proxycheckPlaceDisk(int row, int column, Color color, boolean turn) {
		return checkPlaceDisk(row, column, color, turn);
	}
	
	public boolean placeDisk(int row, int column, Color color) {
		boolean turn = true;
		boolean diskPlaced = false;
		
		if (checkPlaceDisk(row, column, color, !turn) == true){
			if(gameBoard[row][column] == null) {
				gameBoard[row][column] = new Disk(color);
				diskPlaced = checkPlaceDisk(row, column, color, turn);
			}
			
			updateScore();
			return diskPlaced;
			
		}
		else {
			return diskPlaced;
			
		}
	}
	
	public boolean isFull() {
		return ((this.totalWhites + this.totalBlacks) == 64);
	}
	
	public int countCellstoDisk(int[] cells) {
		int sumCells= 0;
		for (int cell : cells) {
			if (cell >0) {
				
				sumCells =+ cell;
			}
		}
		return sumCells;
	}
	
	public Coordinate checkDirection(int row, int col, Direction direction) {
 
		switch(direction) {
			case up:
					row = -1;
					break;
			case down:
					row = 1;
					break;
				
			case left: 
					col = -1;
					break;
				
			case right:
					col = 1;
					break;
				
			case up_left_diagonal:
					row = -1;
					col = -1;
					break;
					
			case up_right_diagonal:
					row = -1;
					col = +1;
					break;
				
			case down_left_diagonal:
					row = +1;
					col = -1;
					break;
				
			case down_right_diagonal:
					row = +1;
					col = +1;
					break;
		}
		return new Coordinate(row, col);
	}
	
	@Override
	public String toString() {
		String board = "   1  2  3  4  5  6  7  8\n";
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
