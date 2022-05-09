package Board;

import Enum.Directions;
import Submarine.Submarine;

public class Board {
	private final int LENGTH = 10;
	private final int WHIDTH = 10;

	private String[][] matBord;

	public Board() {
		matBord = new String[LENGTH+2][WHIDTH+2];
		for (int i = 0; i < matBord.length; i++) {
			for (int j = 0; j < matBord.length; j++) {
				if(i == 0 || j == 0 || i == matBord.length-1 || j == matBord[i].length-1)
					matBord[i][j] = "*";
				else
					matBord[i][j] = "_";
			}
		}
	}

	public void printBord() {
		for (int i = 0; i < matBord.length; i++) {
			for (int j = 0; j < matBord.length; j++) {
				System.out.print(matBord[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void createSubmarineInBord(Submarine submarine) {
		for (int i = 0; i < submarine.getX().length; i++) {
			matBord[submarine.getX()[i]][submarine.getY()[i]] = "[]";
			setFrame(submarine);
		}

	}

	public boolean contains(final int[] array, final int v) {

		boolean result = false;

		for(int i : array){
			if(i == v){
				result = true;
				break;
			}
		}

		return result;
	}

	public void setFrame(Submarine submarine) {
		for (int i = 0; i < submarine.getX().length; i++) {
			//right
			if(!contains(submarine.getX(),submarine.getX()[i]+1)) {
				matBord[submarine.getX()[i]+1][submarine.getY()[i]] = ".";
			}
			//left
			if(!contains(submarine.getX(),submarine.getX()[i]-1)) {
				matBord[submarine.getX()[i]-1][submarine.getY()[i]] = ".";
			}
			//up
			if(!contains(submarine.getY(),submarine.getY()[i]+1) ) {
				matBord[submarine.getX()[i]][submarine.getY()[i]+1] = ".";
			}
			//downe
			if(!contains(submarine.getY(),submarine.getY()[i]-1) ) {
				matBord[submarine.getX()[i]][submarine.getY()[i]-1] = ".";
			}

		}

	}

	public boolean isLegal(int x, int y, Directions directions) {
		if(matBord[x][y].equals("[]"))
			return false;
		if(matBord[x+1][y].equals("[]") && directions != Directions.RIGHT) 
			return false;
		if(matBord[x-1][y].equals("[]") && directions != Directions.LEFT) 
			return false;
		if(matBord[x][y+1].equals("[]") && directions != Directions.UP) 
			return false;
		if(matBord[x][y-1].equals("[]") && directions != Directions.DOWN) 
			return false;

		return true;
	}
	
	public void setGuessInBord(int x, int y) {
		if(matBord[x][y].equals("[]"))
			matBord[x][y] = "bool";
		matBord[x][y] = "$";
	}
}
