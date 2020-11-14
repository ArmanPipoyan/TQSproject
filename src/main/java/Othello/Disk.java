package Othello;

public class Disk {
	private Color color;
	
	Disk(Color color){
		this.color=color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void turn() {
		if(color==Color.Black) {
			color=Color.White;
		}else {
			color=Color.Black;
		}
	}
	
}
