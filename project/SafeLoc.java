package project;

import java.util.Scanner;

public abstract class SafeLoc extends Location {
	
	public SafeLoc(Player player, String name) {
		super(player, name);
	}

	@Override
	public void onLocation() {
		System.out.println("You are now in a safe location!");
	}

	


}
