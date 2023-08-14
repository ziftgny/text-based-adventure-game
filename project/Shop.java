package project;

import java.util.Scanner;

public class Shop extends SafeLoc{
	private static boolean isItFirst=true;
	public Shop(Player player, String name) {
		super(player, name);
	}
	
	@Override
	public void onLocation(){
		if(Shop.isItFirst==true) {
			System.out.println("Welcome to the shop! you can buy stuff to equip yourself against monsters!\n"
					+ "dont forget you get to equip one item at a time");
			Shop.isItFirst=false;
		}
		System.out.println("You are now in "+this.getName());
		menu();
	}

	public void menu() {
		/*in this code block with the inner do while loop we make sure user inputs are correct 
		  and intended we can also go back to the main menu with 'q' letter.
		  As we add more branches with "switch(EquipmentSelection)" we may want to go one step
		  back if we press 'q' it takes us to the last branch we were before we entered our last input  */
		int weaponloopchecker;//if checkers get value 1 we go back by 1 step if its
		int armorloopchecker;//0 we go back to the first menu (choose action menu)
		do {
			weaponloopchecker=0;
			armorloopchecker=0;
			System.out.println("Select equipment type");
			System.out.println("------------------------------");
			System.out.println("1)Weapons");
			System.out.println("2)Armors");
			System.out.println("q)go back");
			int equipmentSelection=0;
				do
				{	
						if(!this.getInput().hasNextInt())
						{
							if (this.getInput().nextLine().equals("q"))
							break;
							System.out.println("enter valid values");
							continue;
						}
						equipmentSelection=this.getInput().nextInt();
						this.getInput().nextLine();
						switch(equipmentSelection)
						{
							case 1:
								weaponloopchecker=this.showWeapons();
							break;
							case 2:
								armorloopchecker=this.showArmors();
							break;
							default:
								System.out.println("enter a valid value");
								break;
						}
				}while(!(equipmentSelection>=1 && equipmentSelection<=2));
		}while(weaponloopchecker==1 || armorloopchecker==1);
	
	}
	
	public int showWeapons() {
		int weaponloopchecker=0;
		Weapon[] weapon = {new Weapon(1,"Revolver",2,25),new Weapon(2,"Rapier",3,35),new Weapon(3, "Rifle", 7, 45)};
		System.out.println("Weapons");
		System.out.println("------------------------------");
		System.out.println("ID   NAME        DAMAGE       COST");
		for (Weapon i : weapon) {
			System.out.printf("%d)   %-8s%10d%11d\n",i.getId(),i.getName(),i.getDamage(),i.getCost());
		}
		System.out.println();
		System.out.println("q)go back");
		weaponloopchecker=buy(weapon);
		if (weaponloopchecker==1)
			return 1;
		return 0;
	}
	public int showArmors() {
		int armorloopchecker=0;
		Armor[] armor = {new Armor(1,"Leather Armor",1,15),new Armor(2,"Chain Mail",3,25),new Armor(3, "Iron Armor", 5, 40)};
		System.out.println("Armors");
		System.out.println("------------------------------");
		System.out.println("ID   NAME              IGNORE       COST");
		for (Armor i : armor) {
			System.out.printf("%d)   %-23s%-10d%d\n",i.getId(),i.getName(),i.getIgnore(),i.getCost());
		}
		System.out.println();
		System.out.println("q)go back");
		armorloopchecker=buy(armor);
		if (armorloopchecker==1)
			return 1;
		return 0;
	}
	
	public int buy(Weapon[] weapon) {
	do {	
		
		if(!this.getInput().hasNextInt())
		{
			if(this.getInput().nextLine().equals("q"))
				return 1;
			System.out.println("enter valid values");
			continue;
		}
		int checker=0;
		int selectedItem = this.getInput().nextInt();
		this.getInput().nextLine();
		for (int i =0; i<weapon.length;i++) {
			if(weapon[i].getId()==selectedItem) {
				checker++;
				
				if(this.getPlayer().getMoney()>=weapon[i].getCost()) {
					
						if(this.getPlayer().getInventory().getBoughtWeapons()[i]==false) {
							int remaining = this.getPlayer().getMoney()- weapon[i].getCost();
							this.getPlayer().setMoney(remaining);
							System.out.println("purchase was successful!");
							System.out.println("you have "+remaining+" gold left");
							this.getPlayer().getInventory().setBoughtWeapons(weapon[i]);
						}
						else
						{
							System.out.println("you already bought that item");
						}
					
					}
					else 
					{
							System.out.println("not enough money");
					}
			}
		}
		if (checker==0)
			System.out.println("there is no item for that id");
	}while(true);
	
	
	}
	
	public int buy(Armor[] armor) {
		do {	
			
			if(!this.getInput().hasNextInt())
			{
				if(this.getInput().nextLine().equals("q"))
					return 1;
				System.out.println("enter valid values");
				continue;
			}
			int checker=0;//checking if the item is in the array
			int selectedItem = this.getInput().nextInt();
			this.getInput().nextLine();
			for (int i =0; i<armor.length;i++) {
				if(armor[i].getId()==selectedItem) {
					checker++;
					
					if(this.getPlayer().getMoney()>=armor[i].getCost()) {
						
							if(this.getPlayer().getInventory().getBoughtArmors()[i]==false) {
								int remaining = this.getPlayer().getMoney()- armor[i].getCost();
								this.getPlayer().setMoney(remaining);
								System.out.println("purchase was successful!");
								System.out.println("you have "+remaining+" gold left");
								this.getPlayer().getInventory().setBoughtArmors(armor[i]);
							}
							else
							{
								System.out.println("you already bought that item");
							}
						
						}
						else 
						{
								System.out.println("not enough money");
						}
				}
			}
			if (checker==0)
				System.out.println("there is no item for that id");
		}while(true);
	}
	
}
