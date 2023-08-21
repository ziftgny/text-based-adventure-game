package project;

import java.util.InputMismatchException;
import java.util.Scanner;
import project.Game;
public class Main {

	public static void main(String[] args) {
		int returnvalue=0;
		Scanner scanner = new Scanner(System.in);
		int input=0;
		do {
		Game game = new Game();
		returnvalue=game.start();
		if(returnvalue==3) {
		System.out.println("1)play again");
		System.out.println("any key to quit");
		}
		else if(returnvalue==1) {
			break;
		}
		try {
			input = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			
			
		}
		}while(input==1);
	}

}
