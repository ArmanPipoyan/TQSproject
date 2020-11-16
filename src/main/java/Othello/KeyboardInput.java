package Othello;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KeyboardInput {
	/*
	 * Control the coordinates (x, y) inputted by the user
	 * 
	 */

	private Scanner input;
	
	
	public KeyboardInput() {
		input = new Scanner(System.in);
	}
	
	protected Coordinate integersCoordinates() {
		try {
			int coordinate_x =input.nextInt();
			int coordinate_y =input.nextInt();
			return new Coordinate(coordinate_x, coordinate_y);
		} catch (InputMismatchException ime) {
			 System.out.println("Only integers can be entered");
			 input.next();
			 return new Coordinate(-1, -1);
		}
	}
	

}
