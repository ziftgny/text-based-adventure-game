package project;

import java.util.Scanner;

public abstract class SafeLoc extends Location {
	private static int locationSwitch=0;
	//locationSwitch is our variable to declare which map is our character in
	//1-SafeHouse
	//2-Battle Loc
	private Scanner input = new Scanner(System.in);
	public SafeLoc(Player player, String name) {
		super(player, name);
	}

	@Override
	public void onLocation() {
		System.out.println("You are now in a safe location!");
	}

	public static int getLocationSwitch() {
		return locationSwitch;
	}

	public static void setLocationSwitch(int locationSwitch) {
		SafeLoc.locationSwitch = locationSwitch;
	}
	


}
