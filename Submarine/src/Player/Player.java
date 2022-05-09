package Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Board.Board;
import Submarine.Submarine;

public class Player {

	private int guesses;
	private int points;
	private final int NUM_SUBMARINE = 4;
	private Submarine[] submarines = new Submarine[5];
	private Board board;
	String name;
	String email;
	float number;
	Guess[] guess;
	
	public Player(String name, String emaile, float number) {
		this.name = name;
		this.email = emaile;
		this.number = number;
		this.guess = new Guess[200];
		guesses = 100;
		points = 1000;
		board = new Board();
		for (int i = 1; i < NUM_SUBMARINE; i++) {
			this.submarines[0] = new Submarine(i, board);
		}
		board.printBord();
	}
	
	public int[] randomIndex() {
		int[] arrCordinatot = new int[2];
		arrCordinatot[0] = Submarine.rand.nextInt(10)+1;
		arrCordinatot[1] = Submarine.rand.nextInt(10)+1;

		return arrCordinatot;
	}
	
	public void setGuessArr() {
		int[] temp = new int[2];
		for (int i = 0; i < guess.length; i++) {
			temp = randomIndex();
			this.guess[i] = new Guess(temp[0], temp[1]);
			this.board.setGuessInBord(temp[0], temp[1]);
		}
		setGuessInFile(this.guess);
	}
	
	private void setGuessInFile(Guess[] guess) {

			try (FileOutputStream fileOut = new FileOutputStream("src/myFiles/objFile1.dat", true);
					// Creates an ObjectOutputStream
					ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
				for (int i = 0; i < guess.length; i++) {
					objOut.writeObject(guess[i]);
				}
					
				
				
			}catch(IOException e){
				System.out.println(e);
			}

		}
	
	public static void ObjectReaderDemo()  {
		try (FileInputStream file = new FileInputStream("src/myFiles/objFile1.dat");
				// Creates an ObjectOutputStream
				ObjectInputStream objStream = new ObjectInputStream(file);) {
			for (int i = 0; i < 200; i++) {
				System.out.println("Guess" +i+": " + (Guess)objStream.readObject());
			}
		}catch(IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void replay(String path) {
		try (FileInputStream file = new FileInputStream(path);
				// Creates an ObjectOutputStream
				ObjectInputStream objStream = new ObjectInputStream(file);) {
			Guess gues;
			for (int i = 0; i < 200; i++) {
				gues =  (Guess)objStream.readObject();
				try {
				    Thread.sleep(1000);
				} catch (InterruptedException ie) {
				    Thread.currentThread().interrupt();
				}
				board.setGuessInBord(gues.getX(), gues.getY());
				board.printBord();
				
			}
		}catch(IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
