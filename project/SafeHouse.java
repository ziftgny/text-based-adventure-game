package project;

import java.util.Scanner;

public class SafeHouse extends SafeLoc{
	private static boolean isItFirst=true;
	private int locControl=0;
	private Scanner input = new Scanner(System.in);
	public SafeHouse(Player player, String name) {
		super(player, name);
	}
	@Override
	public void onLocation() {
		if (SafeHouse.isItFirst==true) {
			System.out.println("This is your safe house! one of the safe locations here you protected from monsters and can restore your health");
			SafeHouse.isItFirst=false;
			
		}
		setLocationSwitch(1);
		System.out.println("You are now in "+this.getName());
		System.out.println("Your health has been restored");
	}
	
	

}
