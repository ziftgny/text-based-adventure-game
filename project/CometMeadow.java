package project;

public class CometMeadow extends BattleLoc {
	private boolean isItFirst=true;
	Obstacle[] obstacles = {new Obstacle("Mutated Pig",2,4,14,7),new Obstacle("Mutated Pig",2,4,14,7),new Obstacle("Mutated Pig",2,4,14,7)};
	public CometMeadow(Player player, String name) {
		super(player, name);
	}
	public void onLocation() {
		if(isItFirst==true) {
			System.out.println("You heard about a mysterious meteor crashing recently on island when you arrived on the place\nyou see 3 mutated pigs it looks like they inherited meteor's strength");
			isItFirst=false;
		}
		if(battle(obstacles)==0) {
			player.getInventory().setStarforgedAlloy(true);
			System.out.println("Received item : The Starforged Alloy: A rare and resilient metal found within the remains of an ancient meteor that crashed\n on the island long ago. This extraordinary material is lightweight and magically resistant, making it ideal\n for constructing the ship's frame and hull. It grants the vessel unparalleled durability,\n enabling it to withstand powerful storms, dangerous creatures, and hostile enchantments.");
		}
	}
}
