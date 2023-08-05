package project;

public abstract class Inventory {
	private static boolean celestialHeartwood;
	private static boolean starforgedAlloy;
	private static boolean aquaPearl;
	private static Weapon equippedWeapon;
	private static Armor equippedArmor;
	private static boolean[] boughtWeapons= {false,false,false};
	private static boolean[] boughtArmors= {false,false,false};
	private Armor[] armor = {new Armor(1,"Leather Armor",1,15),new Armor(2,"Chain Mail",3,25),new Armor(3, "Iron Armor", 5, 40)};
	private Weapon[] weapon = {new Weapon(1,"Revolver",2,25),new Weapon(2,"Rapier",3,35),new Weapon(3, "Rifle", 7, 45)};

	public void showInventory() {
		
	}
	public boolean isCelestialHeartwood() {
		return celestialHeartwood;
	}
	public void setCelestialHeartwood(boolean celestialHeartwood) {
		this.celestialHeartwood = celestialHeartwood;
	}
	public boolean isStarforgedAlloy() {
		return starforgedAlloy;
	}
	public void setStarforgedAlloy(boolean starforgedAlloy) {
		this.starforgedAlloy = starforgedAlloy;
	}
	public boolean isAquaPearl() {
		return aquaPearl;
	}
	public void setAquaPearl(boolean aquaPearl) {
		this.aquaPearl = aquaPearl;
	}
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}
	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}
	public Armor getEquippedArmor() {
		return equippedArmor;
	}
	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}
	public Armor[] getArmor() {
		return armor;
	}
	public Weapon[] getWeapon() {
		return weapon;
	}
	public static boolean[] getBoughtWeapons() {
		return boughtWeapons;
	}
	public static void setBoughtWeapons(Weapon weapon) {
		Inventory.boughtArmors[weapon.getId()-1] = true;
	}
	public static boolean[] getBoughtArmors() {
		return boughtArmors;
	}
	public static void setBoughtArmors(Armor armor) {
		Inventory.boughtArmors[armor.getId()-1] = true;
	}
	
	
}
