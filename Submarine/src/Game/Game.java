package Game;

import Submarine.Submarine;
import Board.Board;
import Enum.Directions;
import Player.Player;

public class Game {

	public static void main(String[] args) {
//		game.printBord();
//		int x[] = {3,3};
//		int y[] = {6,7};
//		Submarine submarine = new Submarine(x,y);
//		game.createSubmarineInBord(submarine);
//		
//		System.out.println(game.isLegal(3, 5, Directions.LEFT ));
		
//		submarine.CreateSubmarine(1);
		
		Player player = new Player("Ayala","ayalla120120@gmail.com",0583250512f);
		player.setGuessArr();
//		player.ObjectReaderDemo();
		player.replay("src/myFiles/objFile1.dat");
	
	}

}
