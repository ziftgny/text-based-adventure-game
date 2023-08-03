package project;

import java.util.Scanner;

public class Shop extends SafeLoc{
	private static int isItFirst=0;
	public Shop(Player player, String name) {
		super(player, name);
	}
	
	@Override
	public void onLocation(){
		if(this.getIsItFirst()==0) {
			System.out.println("Welcome to the shop! you can buy stuff to equip yourself against monsters!\n"
					+ "dont forget you get to equip one item at a time");
			this.setIsItFirst(1);
		}
		System.out.println("You are now in "+this.getName());
		menu();
	}

	public void menu() {
		System.out.println("Select equipment type");
		System.out.println("------------------------------");
		System.out.println("1)Weapons");
		System.out.println("2)Armors");
		System.out.println("q)go back");
		char equipmentSelection='0';
		do
		{
			equipmentSelection=this.getInput().next().charAt(0);
			switch(equipmentSelection)
			{
				case '1':
					this.showWeapons();
				break;
				case '2':
					this.showArmors();
				break;
				case 'q':		
				break;
				default:
					System.out.println("enter a valid value");
					break;
			}
		}while(equipmentSelection!='1' && equipmentSelection!='2' && equipmentSelection!='q');
			
	}
	public void buy() {
		
	}
	
	public void showWeapons() {
		Weapon[] weapon = {new Revolver(),new Rapier(),new Rifle()};
		System.out.println("Weapons");
		System.out.println("------------------------------");
		System.out.println("ID   NAME        DAMAGE       COST");
		for (Weapon i : weapon) {
			System.out.printf("%d)   %-8s%10d%11d\n",i.getId(),i.getName(),i.getDamage(),i.getCost());
		}
		System.out.println();
		System.out.println("q)go back");
		if(this.getInput().next().charAt(0)=='q')
			menu();
	}
	public void showArmors() {
		Armor[] armor = {new LeatherArmor(),new ChainMail(),new IronArmor()};
		System.out.println("Armors");
		System.out.println("------------------------------");
		System.out.println("ID   NAME              IGNORE       COST");
		for (Armor i : armor) {
			System.out.printf("%d)   %-23s%-10d%d\n",i.getId(),i.getName(),i.getIgnore(),i.getCost());
		}
		System.out.println();
		System.out.println("q)go back");
		if(this.getInput().next().charAt(0)=='q')
			menu();
	}
	
	public int getIsItFirst() {
		return isItFirst;
	}
	public void setIsItFirst(int isItFirst) {
		this.isItFirst = isItFirst;
	}
}
