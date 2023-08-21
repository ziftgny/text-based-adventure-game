package project;

public class UnderwaterCave extends BattleLoc{
	private boolean isItFirst = true;
	Obstacle[] obstacles= {new Obstacle("Siren defenders",3,7,20,12),new Obstacle("Siren defenders",3,7,20,12),new Obstacle("Siren defenders",3,7,20,12)};
	public UnderwaterCave(Player player, String name) {
		super(player, name);
	}
	public void onLocation() {
		if(isItFirst==true) {
			System.out.println("You found an underwater cave while you were exploring the island\n when you walked deeper into the cave you faced a bareer you touched and passed it slowly\nlooks like you are underwater yet no feeling of choking or swimming. You saw a pearl guarded by 3 sirens...");
			isItFirst=false;
		}
		if(battle(obstacles)==0) {
			player.getInventory().setAquaPearl(true);
			System.out.println("Received item : The Aqua Pearl: For the ship to sail the vast seas, it requires a material with a strong connection\n to water.It has the remarkable ability to harness the energy of the tides and grants the ship the power\n to control water currents, aiding in navigation and protection against storms.");
		}
	}

}
