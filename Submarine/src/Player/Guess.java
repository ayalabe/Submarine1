package Player;

import java.io.Serializable;

public class Guess implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	
	public Guess( int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Guess [x=" + x + ", y=" + y + "]";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
