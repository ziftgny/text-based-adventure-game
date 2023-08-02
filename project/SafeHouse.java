package project;

import java.util.Scanner;

public class SafeHouse extends SafeLoc{
	private int isItFirst=0;
	private int locControl=0;
	private Scanner input = new Scanner(System.in);
	public SafeHouse(Player player, String name) {
		super(player, name);
	}
	@Override
	public void onLocation() {
		if (this.getIsItFirst()==0) {
			System.out.println("This is your safe house! one of the safe locations here you protected from monsters and can restore your health");
			this.setIsItFirst(1);
			setLocationSwitch(1);
		}
		System.out.println("You are now in "+this.getName());
		System.out.println("Your health has been restored");
	}
	public int getIsItFirst() {
		return isItFirst;
	}
	public void setIsItFirst(int isItFirst) {
		this.isItFirst = isItFirst;
	}
	

}
