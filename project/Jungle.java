package project;

public class Jungle extends BattleLoc {
	private boolean isItFirst=true;
	private Obstacle[] obstacles = {new Obstacle("Tree Sentinel",1,3,10,4),new Obstacle("Tree Sentinel",1,3,10,4),new Obstacle("Tree Sentinel",1,3,10,4)};
	public Jungle(Player player, String name) {
		super(player, name);
	}
	
	@Override
	public void onLocation() {
			if(isItFirst==true) {
				System.out.println("As you go deeper into the woods you saw a giant tree guarded by 3 tree shaped guards");
				isItFirst=false;
			}
			if(battle(obstacles)==0) {
				player.getInventory().setCelestialHeartwood(true);
				System.out.println("Received item : The Celestial Heartwood this is a rare and magical wood that can only be found deep\n within the heart of a mystical forest on the island. The tree that produces this wood is said to be connected to the stars\n and absorbs the essence of celestial bodies. The Celestial Heartwood is imbued with ancient power and resilience,\n making it perfect for crafting the main structure of the ship.");
			}
		}

}
