package project;

import java.util.Scanner;

public  class Inventory {
	private Player player;
	private Scanner input = new Scanner(System.in);
	private boolean isItFirst=true;
	private boolean celestialHeartwood=false;
	private boolean starforgedAlloy=false;
	private boolean aquaPearl=false;
	private Weapon equippedWeapon=null;
	private Armor equippedArmor=null;
	private boolean[] boughtWeapons= {false,false,false};
	private boolean[] boughtArmors= {false,false,false};
	// should have used a database for these but whatever...
	private  Armor[] armor = {new Armor(1,"Leather Armor",1,15),new Armor(2,"Chain Mail",3,25),new Armor(3, "Iron Armor", 5, 40)};
	private  Weapon[] weapon = {new Weapon(1,"Revolver",2,25),new Weapon(2,"Rapier",3,35),new Weapon(3, "Rifle", 7, 45)};
	Inventory(Player player){
		this.player = player;
	}
	public  void onLocation() {
		System.out.println("INVENTORY");
		System.out.println("------------------------------");
		if(this.isItFirst==true) {
			System.out.println("This is your inventory! Here you can see ; The items you have bought,crucial items you have gathered for building your ship\n"
					+ "and info about your character");
		}
		System.out.println();
		this.isItFirst=false;
		showInventory();
		
	}
	public  void showInventory() {
		int weaponloopchecker;//if checkers get value 1 we go back by 1 step if its
		int armorloopchecker;//0 we go back to the first menu (choose action menu)
		do {
			weaponloopchecker=0;
			armorloopchecker=0;
			characterinfo();
			System.out.println();
			showShipParts();
			System.out.println();
			showEquippedItems();
			System.out.println();
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
					if (!this.input.hasNextInt())
						{
							if (this.input.nextLine().equals("q"))
							break;
							System.out.println("enter valid values");
							continue;
						}
						equipmentSelection=input.nextInt();
						this.input.nextLine();
						switch(equipmentSelection)
						{
							case 1:
								weaponloopchecker=equipWeapon();
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
	public  void characterinfo() {
		System.out.print("Username:"+player.getName()+"   Class:"+player.getChoosenClass().getName()+"   Damage:"+player.getDamage()+"   Health:"+player.getHealth()+"   Money:"+player.getMoney()+"   Ignore:");
		if(this.equippedArmor==null) {
			System.out.println(0);
		}
		else {
			System.out.println(this.equippedArmor.getIgnore()); 
		}
	}
	public  void showShipParts() {
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
	
	public  void showEquippedItems() {
		if (this.equippedArmor == null) {
			System.out.print("Equipped armor:"+"-"+"   ");
		}
		else
		System.out.print("Equipped armor:"+this.equippedArmor.getName()+"   ");
		if (equippedWeapon == null) {
			System.out.print("Equipped weapon:"+"-");
		}
		else
		System.out.print("Equipped weapon:"+this.equippedWeapon.getName());
		System.out.println();
	}
	
	
	public void showWeapon() {
		int counter =0;
		System.out.println("WEAPONS");
		System.out.println("------------------------------");
		for(int i=0;i<this.boughtWeapons.length;i++) {
			if(this.boughtWeapons[i]==true) {
				System.out.print(this.weapon[i].getName()+"   ");
				counter++;
			}
		}
		System.out.println();
		if (counter==0)
			System.out.println("there are no weapons bought");
	}
	
	public  void showArmor() {
		int counter=0;
		System.out.println("ARMORS");
		System.out.println("------------------------------");
		for(int i=0;i<this.boughtArmors.length;i++) {
			if(boughtArmors[i]==true) {
				System.out.print(armor[i].getName()+"   ");
				counter++;
			}
			
		}
		System.out.println();
		if (counter==0)
			System.out.println("there are no armors bought");
	
	}
	
	public  int equipArmor( ) {
		
		do {	
			int counter=0;
			System.out.println("Armors");
			System.out.println("------------------------------");
			System.out.println("ID   NAME              IGNORE");
			for(int i=0;i<this.boughtArmors.length;i++) {
				if(this.boughtArmors[i]==true) {
					System.out.printf("%d)   %-23s%-10d\n",this.armor[i].getId(),this.armor[i].getName(),this.armor[i].getIgnore());

					counter++;
				}
			}
			System.out.println();
			if (counter==0)
				System.out.println("there are no armors bought");
			System.out.println("q)go back");
			if(!this.input.hasNextInt())
			{
				if(this.input.nextLine().equals("q"))
					return 1;
				System.out.println("enter valid values");
				continue;
			}
			int checker=0;
			int selectedItem = this.input.nextInt();
			this.input.nextLine();
			for (int i =0;i<this.boughtArmors.length;i++) {
				if((i+1)==selectedItem && this.boughtArmors[i]==true) {
					equippedArmor=this.armor[i];
					
					System.out.println("item has been equipped");
					checker++;
				}
			}
			if (checker==0)
				System.out.println("there is no item for that id");
		}while(true);
		
		
		
	}
	public  int equipWeapon() {

		do {	
			int counter=0;
			System.out.println("Weapons");
			System.out.println("------------------------------");
			System.out.println("ID   NAME        DAMAGE");
			for(int i=0;i<this.boughtWeapons.length;i++) {
				if(this.boughtWeapons[i]==true) {
					System.out.printf("%d)   %-8s%10d\n",this.weapon[i].getId(),this.weapon[i].getName(),this.weapon[i].getDamage());
					counter++;
				}
			}
			System.out.println();
			if (counter==0)
				System.out.println("there are no armors bought");
			System.out.println("q)go back");
			if(!this.input.hasNextInt())
			{
				if(this.input.nextLine().equals("q"))
					return 1;
				System.out.println("enter valid values");
				continue;
			}
			int checker=0;
			int selectedItem = this.input.nextInt();
			this.input.nextLine();
			for (int i =0;i<this.boughtWeapons.length;i++) {
				if((i+1)==selectedItem && this.boughtWeapons[i]==true) {
					this.equippedWeapon=this.weapon[i];
					this.player.setDamage(this.equippedWeapon.getDamage());
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
	public  boolean[] getBoughtWeapons() {
		return boughtWeapons;
	}
	public  void setBoughtWeapons(Weapon weapon) {
		this.boughtWeapons[weapon.getId()-1] = true;
	}
	public  boolean[] getBoughtArmors() {
		return boughtArmors;
	}
	public  void setBoughtArmors(Armor armor) {
		this.boughtArmors[armor.getId()-1] = true;
	}
	
	
}
