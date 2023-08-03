package project;

public abstract class BattleLoc extends Location {

	public BattleLoc(Player player, String name) {
		super(player, name);
	}

	@Override
	public void onLocation() {
		System.out.println("Choose area");
		System.out.println("--------------");
	}

}
