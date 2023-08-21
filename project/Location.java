package project;

import java.util.Scanner;

public abstract class Location {
		protected static Scanner input = new Scanner(System.in);
		private static int locationSwitch=0;
		//locationSwitch is our variable to declare which map is our character in
		//1-SafeHouse
		//2-Battle Loc
		protected Player player;
		private String name;
		
		public Location(Player player, String name) {
			super();
			this.player = player;
			this.name = name;
		}
		
		public abstract void onLocation();

		public Player getPlayer() {
			return player;
		}

		public void setPlayer(Player player) {
			this.player = player;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public static int getLocationSwitch() {
			return locationSwitch;
		}

		public static void setLocationSwitch(int locationSwitch) {
			Location.locationSwitch = locationSwitch;
		}

		public Scanner getInput() {
			return input;
		}

		
		
		
		

}