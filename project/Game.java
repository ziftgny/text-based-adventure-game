package project;
import java.io.*;
import java.util.*;

public class Game {
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		System.out.println("You slowly regain consciousness, the gentle lapping of waves against the shore reaching your ears. Blinking against \n"
		+ "the bright"
		+ " sunlight"
		+ ", you find yourself lying on a pristine beach, surrounded by the wreckage of your ship.\n"
		+ "Your heart quickens as you remember the attack by pirates, and the realization dawns upon you that you are now stranded on this \n"
		+ "mysterious island,"
		+ " separated from your crew.\n"
		+ "The island's beauty is undeniable.The azure waters, the swaying palm trees, and the vibrant colors of the flora. But beneath\n"
		+ "its alluring surface"
		+ "lies an air of mystery and danger.\n"
		+ "With a deep breath, you rise to your feet, feeling the sand between your toes. You know you must act swiftly to survive.\nYour adventure has taken an \n"
		+ "unexpected turn, and this is where your true test begins.\n");
		
		System.out.println("Welcome to the game!");
		System.out.print("Please enter a name: ");
		String name = input.nextLine();
		Player player = new Player(name);
		player.selectClass();
		System.out.println("Player named "+player.getName()+" created from "+player.getClassName()+" class!");
		SafeHouse safeHouse = new SafeHouse(player,"Safe House");
		System.out.println("You found a tribe in the woods offering shelter. Despite the language barrier, you bonded with\n"
		+ "them. They revealed that to escape the island, you must clear monster-inhabited places and gather\n"
		+ "materials for a ship.");
		safeHouse.onLocation();
		while(true) {
			
				System.out.println("Choose an action!");
				System.out.println("------------------------------");
				System.out.println("1)Move");
				System.out.println("2)Shop");
				System.out.println("3)Inventory");
				int action_input = 0;
				do {
					action_input=input.nextInt();
					switch(action_input) {
					case 1:
						move(player);
						break;
					case 2:
						Shop shop = new Shop(player,"Shop");
						shop.onLocation();
						break;
					case 3:
						break;
					default:
						System.out.println("enter a valid value");
						break;
					}
					}while(action_input!=1 && action_input!=2 && action_input!=3);
				
				}
	}
	public void move(Player player) {
		System.out.println("Where do you want to go?");
		System.out.println("------------------------");
		System.out.println("1)Safe House");
		System.out.println("2)Battle Locs");
		int action_input = 0;
		do {
				action_input=input.nextInt();
				switch(action_input) {
				case 1:
					if(SafeLoc.getLocationSwitch()==1)
						System.out.println("you are already there");
						SafeHouse safehouse = new SafeHouse(player,"Safe House");
						safehouse.onLocation();
					break;
				case 2:
					break;
				default:
					System.out.println("enter a valid value");
					break;
				}
		}while(action_input!=1 && action_input!=2 );
		
		}
	}
