package Player;

import Bord.Bord;
import Submarine.Submarine;

public class Player {

	private int guesses;
	private int points;
	private final int NUM_SUBMARINE = 5;
	private Submarine[] submarines = new Submarine[5];
	private Bord bord;
	
	public Player() {
		guesses = 100;
		points = 1000;
		bord = new Bord();
//		for (int i = 0; i < NUM_SUBMARINE; i++) {
			this.submarines[0] = new Submarine(1, bord);
//		}
		bord.printBord();
	}
}
