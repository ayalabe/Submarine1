package Submarine;

import java.util.Random;
import Enum.Directions;
import Bord.Bord;

public class Submarine {

	static Random rand = new Random();
	private int[] x;
	private int[] y;
	Directions directions;
	int index;



	public Submarine(int size, Bord bord) {
		index = 0;
		directions = Directions.DIFOLTE;
		CreateSubmarine(size, bord);
	}


	public int[] getX() {
		return x;
	}


	public void setX(int x) {
		this.x[index] = x;
		index++;
	}


	public int[] getY() {
		return y;
	}


	public void setY(int y) {
		this.y[index] = y;
		index++;
	}

	private int[] addShape(int x, int y, Bord bord) {
//		int[] point;
//		int[] tempX;
//		int[] tempY;
//		do {
//			point = getCordinatAraundCenter(point);
//			tempX[0] = point[0];
//			tempY[0] = point[1];
//		}while(!bord. isLegal(point[0], point[1], Directions.DIFOLTE));
		return null;
	}
	public void CreateSubmarine(int size, Bord bord) {
		switch(size) {
		case 1:
			CreateSubmarine1(size, bord);
		case 2:
		}
	}

	public void CreateSubmarine1(int size, Bord bord) {
		int[] centerPoint;
		int[] tempX = new int[1];
		int[] tempY = new int[1];
		do {
			centerPoint = randomIndex();
			tempX[0] = centerPoint[0];
			tempY[0] = centerPoint[1];
		}while(!bord. isLegal(centerPoint[0], centerPoint[1], Directions.DIFOLTE));
		this.x = tempX;
		this.y = tempY;
		bord.createSubmarineInBord(this);
	}
	
	public void CreateSubmarine2(int size, Bord bord) {
//		CreateSubmarine1(size, bord);
//		int[] tempX = new int[2];
//		int[] tempY = new int[2];
//		int[] point = new int[2];
//		do {
//			point = getCordinatAraundCenter(this.x[0], this.y[0]);
//		}while(!bord. isLegal(point[0], point[1], this.directions));
//		tempX = {this.x[0], point[0]};
//		tempY = {this.x[1], point[1]};
//		point = getCordinatAraundCenter(this.x[0], this.y[0]);
		
	}



	public int[] randomIndex() {
		int[] arrCordinatot = new int[2];
		arrCordinatot[0] = rand.nextInt(10)+1;
		arrCordinatot[1] = rand.nextInt(10)+1;

		return arrCordinatot;
	}

	public int[] getCordinatAraundCenter(int x ,int y) {
		int[] newPoint = new int[2];
		int randBecause = rand.nextInt(4);
		switch(randBecause) {
		case 0:  //up
			newPoint[0] = x;
			newPoint[1] = y++;
			this.directions = Directions.UP;
			break;
		case 1://down
			newPoint[0] = x;
			newPoint[1] = y--;
			this.directions = Directions.DOWN;
			break;
		case 2://right
			newPoint[0] = x++;
			newPoint[1] = y;
			this.directions = Directions.RIGHT;
			break;
		case 3://left
			newPoint[0] = x--;
			newPoint[1] = y;
			this.directions = Directions.LEFT;
			break;
		}
		return newPoint;
	}

}
