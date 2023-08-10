package project;

import java.util.Scanner;

public abstract class Inventory {
	private static Scanner input = new Scanner(System.in);
	private static boolean isItFirst=true;
	private static boolean celestialHeartwood=false;
	private static boolean starforgedAlloy=false;
	private static boolean aquaPearl=false;
	private static Weapon equippedWeapon;
	private static Armor equippedArmor;
	private static boolean[] boughtWeapons= {false,false,false};
	private static boolean[] boughtArmors= {false,false,false};
	// should have used a database for these but whatever...
	private static Armor[] armor = {new Armor(1,"Leather Armor",1,15),new Armor(2,"Chain Mail",3,25),new Armor(3, "Iron Armor", 5, 40)};
	private static Weapon[] weapon = {new Weapon(1,"Revolver",2,25),new Weapon(2,"Rapier",3,35),new Weapon(3, "Rifle", 7, 45)};
	public static void onLocation(Player player) {
		System.out.println("INVENTORY");
		System.out.println("------------------------------");
		if(Inventory.isItFirst==true) {
			System.out.println("This is your inventory! Here you can see ; The items you have bought,crucial items you have gathered for building your ship\n"
					+ "and info about your character");
		}
		Inventory.isItFirst=false;
		showInventory(player);
		
	}
	public static void showInventory(Player player) {
		int weaponloopchecker;//if checkers get value 1 we go back by 1 step if its
		int armorloopchecker;//0 we go back to the first menu (choose action menu)
		do {
			weaponloopchecker=0;
			armorloopchecker=0;
			characterinfo(player);
			System.out.println();
			showShipParts();
			System.out.println();
			showEquippedItems();
			showWeapon();
			System.out.println();
			showArmor();
			System.out.println();
			System.out.println("1)equip weapon");
			System.out.println("2)equip armor");
			System.out.println("q)go back");
			int equipmentSelection=0;
				do
				{	
					if (!input.hasNextInt())
						{
							if (input.nextLine().equals("q"))
							break;
							System.out.println("enter valid values");
							continue;
						}
						equipmentSelection=input.nextInt();
						input.nextLine();
						switch(equipmentSelection)
						{
							case 1:
								
							break;
							case 2:
								armorloopchecker=equipArmor();
							break;
							default:
								System.out.println("enter a valid value");
								break;
						}
				}while(!(equipmentSelection>=1 && equipmentSelection<=2));
		}while(weaponloopchecker==1 || armorloopchecker==1);
	
		
	}
	public static void characterinfo(Player player) {
		System.out.println("Username:"+player.getName()+"   Class:"+player.getClassName()+"   Damage:"+player.getDamage()+"   Health:"+player.getHealth()+"   Money:"+player.getMoney());
	}
	public static void showShipParts() {
		int counter=0;
		boolean[] array = {celestialHeartwood, starforgedAlloy,aquaPearl};
		for (int i =0 ; i<array.length ;i++) {
			if(array[i]==true) {
				switch(i) {
				case 0:
					System.out.print("Celestial Heartwood   ");
					counter++;
					break;
				case 1:
					System.out.print("Starforged Alloy   ");
					counter++;
					break;
				case 2:
					System.out.print("Aqua pearl   ");
					counter++;
					break;
				}
				
			}
		}
		
		if (counter==0)
			System.out.print("there are no ship parts obtained yet");
		System.out.println();
	}
	
	public static void showEquippedItems() {
		System.out.println("Equipped armor:"+equippedArmor);
	}
	
	
	public static void showWeapon() {
		int counter =0;
		System.out.println("WEAPONS");
		System.out.println("------------------------------");
		for(int i=0;i<boughtWeapons.length;i++) {
			if(boughtWeapons[i]==true) {
				System.out.print(weapon[i].getName()+"   ");
				counter++;
			}
		}
		System.out.println();
		if (counter==0)
			System.out.println("there are no weapons bought");
	}
	
	public static void showArmor() {
		int counter=0;
		System.out.println("ARMORS");
		System.out.println("------------------------------");
		for(int i=0;i<boughtArmors.length;i++) {
			if(boughtArmors[i]==true) {
				System.out.print(armor[i].getName()+"   ");
				counter++;
			}
			
		}
		System.out.println();
		if (counter==0)
			System.out.println("there are no armors bought");
	
	}
	
	public static int equipArmor() {
		
		
		do {	
			int counter=0;
			System.out.println("ARMORS");
			System.out.println("------------------------------");
			for(int i=0;i<boughtArmors.length;i++) {
				if(boughtArmors[i]==true) {
					System.out.println(armor[i].getId()+" - "+armor[i].getName());
					counter++;
				}
			}
			System.out.println();
			if (counter==0)
				System.out.println("there are no armors bought");
			System.out.println("q)go back");
			if(!input.hasNextInt())
			{
				if(input.nextLine().equals("q"))
					return 1;
				System.out.println("enter valid values");
				continue;
			}
			int checker=0;
			int selectedItem = input.nextInt();
			input.nextLine();
			for (int i =0;i<boughtArmors.length;i++) {
				if((i+1)==selectedItem && boughtArmors[i]==true) {
					equippedArmor=armor[i];
					System.out.println("item has been equipped");
					checker++;
				}
			}
			if (checker==0)
				System.out.println("there is no item for that id");
		}while(true);
		
		
		
	}
	
	public boolean isCelestialHeartwood() {
		return celestialHeartwood;
	}
	public void setCelestialHeartwood(boolean celestialHeartwood) {
		this.celestialHeartwood = celestialHeartwood;
	}
	public boolean isStarforgedAlloy() {
		return starforgedAlloy;
	}
	public void setStarforgedAlloy(boolean starforgedAlloy) {
		this.starforgedAlloy = starforgedAlloy;
	}
	public boolean isAquaPearl() {
		return aquaPearl;
	}
	public void setAquaPearl(boolean aquaPearl) {
		this.aquaPearl = aquaPearl;
	}
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	public Armor[] getArmor() {
		return armor;
	}
	public Weapon[] getWeapon() {
		return weapon;
	}
	public static boolean[] getBoughtWeapons() {
		return boughtWeapons;
	}
	public static void setBoughtWeapons(Weapon weapon) {
		Inventory.boughtArmors[weapon.getId()-1] = true;
	}
	public static boolean[] getBoughtArmors() {
		return boughtArmors;
	}
	public static void setBoughtArmors(Armor armor) {
		Inventory.boughtArmors[armor.getId()-1] = true;
	}
	
	
}
