package project;
import java.io.*;
import java.util.*;

public class Game {
	private Scanner input = new Scanner(System.in);
	//RETURN VALUE MEANINGS
	//0-DEFAULT
	//1-GO BACK
	//3-DEATH
	public int start() {
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
		System.out.println("Player named "+player.getName()+" created from "+player.getChoosenClass().getName()+" class!");
		SafeHouse safeHouse = new SafeHouse(player,"Safe House");
		System.out.println("You found a tribe in the woods offering shelter. Despite the language barrier, you bonded with\n"
		+ "them. They revealed that to escape the island, you must clear monster-inhabited places and gather\n"
		+ "materials for a ship.");
		safeHouse.onLocation();
		while(true) {
				if(checkend(player)==3)
					return 3;
				if(player.getHealth()<=0) {
					return 3;
				}
				
				//using nextLine() after nextInt() so we can clear our buffer.
				System.out.println("Choose an action!");
				System.out.println("------------------------------");
				System.out.println("1)Move");
				System.out.println("2)Shop");
				System.out.println("3)Inventory");
				System.out.println("4)quit game");
				int action_input = 0;
				do {
					if(!input.hasNextInt())
					{
						System.out.println("enter valid values");
						input.nextLine();
						continue;
					}
					action_input=input.nextInt();
					input.nextLine();
					switch(action_input) {
					case 1:
						move(player);
						
						break;
					case 2:
						Shop shop = new Shop(player,"Shop");
						shop.onLocation();
						
						break;
					case 3:
						player.getInventory().onLocation();
						break;
					case 4:
						return 1;
					default:
						System.out.println("enter a valid value");
						
						break;
					}
					
					}while(!(action_input>=1 && action_input<=3));
				
					
				}
	}
	public void move(Player player) {
		int battleLocLoopCheck=0;
	do {
		battleLocLoopCheck=0;
		System.out.println("Where do you want to go?");
		System.out.println("------------------------------");
		System.out.println("1)Safe House");
		System.out.println("2)Battle Locs");
		System.out.println("q)go back");
		int action_input = 0;
		do {
				if(!input.hasNextInt())
				{
					if(input.nextLine().equals("q"))
					break;
					System.out.println("enter valid values");
					continue;
				}
				action_input=input.nextInt();
				input.nextLine();
				switch(action_input) {
				case 1:
					if(Location.getLocationSwitch()==1)
						System.out.println("you are already there");
					else
					{
						SafeHouse safehouse = new SafeHouse(player,"Safe House");
						safehouse.onLocation();
					}
					break;
				case 2:
					
					if(Location.getLocationSwitch()==2)
						System.out.println("you are already there");
					Location.setLocationSwitch(2);
					battleLocLoopCheck=selectBattleLoc(player);
					break;
				default:
					System.out.println("enter a valid value");
					break;
				}
					
			}while(!(action_input>=1 && action_input<=2));
			
		}while(battleLocLoopCheck==1);
	
	}
		public int selectBattleLoc(Player player) {
			System.out.println("Battle Locations");
			System.out.println("------------------------------");
			System.out.println("1)Jungle");
			System.out.println("2)Comet meadow");
			System.out.println("3)Underwater Cave");
			System.out.println("q)go back");
			int battleLoc_input = 0;
			do {
					if(!input.hasNextInt())
					{
						if(input.nextLine().equals("q"))
						return 1;
						System.out.println("enter valid values");
						continue;
					}
					battleLoc_input=input.nextInt();
					input.nextLine();
					switch(battleLoc_input) {
					case 1:
						Jungle jungle = new Jungle(player, "Jungle");
						jungle.onLocation();
						break;
					case 2:
						CometMeadow cometMeadow = new CometMeadow(player, "Comet Meadow");
						cometMeadow.onLocation();
						break;
					case 3:
						UnderwaterCave underWaterCave = new UnderwaterCave(player, "Underwater Cave");
						underWaterCave.onLocation();
						break;
					default:
						System.out.println("enter a valid value");
						break;
					}
					
			}while(!(battleLoc_input>=1 && battleLoc_input<=3));
			return 0;
		}
		public int checkend(Player player) {
			int checker=0;
			boolean[] boolarray	={	player.getInventory().isAquaPearl(),
									player.getInventory().isCelestialHeartwood(),
									player.getInventory().isStarforgedAlloy()};
			for(boolean i : boolarray) {
				if(i==true)
					checker++;
			}
			if (checker==3) {
				System.out.println("------------------------------");
				System.out.println();
				System.out.println("After gathering the items to build a ship and leave the island. With farewells exchanged, you set sail toward new horizons,\n carrying memories and the island's teachings as they embraced an unknown but promising future.");
				System.out.println();
				System.out.println("------------------------------");

				return 3;
			}
			return 0;
		}
	}
