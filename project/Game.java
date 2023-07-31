package project;
import java.io.*;
import java.util.*;

public class Game {
	private Scanner input = new Scanner(System.in);
	
	void start() {
		System.out.println("You slowly regain consciousness, the gentle lapping of waves against the shore reaching your ears. Blinking against \n"
				+ "the bright"
				+ " sunlight"
				+ ", you find yourself lying on a pristine beach, surrounded by the wreckage of your ship.\n"
				+ "Your heart quickens as you remember the attack by pirates, and the realization dawns upon you that you are now stranded on this \n"
				+ "mysterious island,"
				+ " separated from your crew.\r\n"
				+ "The island's beauty is undeniable—the azure waters, the swaying palm trees, and the vibrant colors of the flora. But beneath\n"
				+ "its alluring surface"
				+ "lies an air of mystery and danger.\r\n"
				+ "With a deep breath, you rise to your feet, feeling the sand between your toes. You know you must act swiftly to survive.\nYour adventure has taken an \n"
				+ "unexpected turn, and this is where your true test begins.\n");
		
		System.out.println("Welcome to the game!");
		System.out.print("Please enter a name: ");
		String name = input.nextLine();
		Player player = new Player(name);
		player.selectClass();
		System.out.println("Player named "+player.getName()+" created from "+player.getClassName()+" class!");
	}
}