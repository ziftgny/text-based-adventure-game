package project;

public class Shop extends SafeLoc{
	private int isItFirst=0;
	public Shop(Player player, String name) {
		super(player, name);
	}
	
	@Override
	public void onLocation(){
		if(this.getIsItFirst()==0) {
			System.out.println("Welcome to the shop! you can buy stuff to equip yourself against monsters!\n"
					+ "dont forget you get to equip one item at a time");
			this.setIsItFirst(1);
		}
		System.out.println("You are now in "+this.getName());
		menu();
	}

	public void menu() {
		Weapon[] weapon = {new Revolver(),new Rapier(),new Rifle()};
		System.out.println("WEAPONS");
		System.out.println("-------------------");
		System.out.println("ID   NAME        DAMAGE       COST");
		for (Weapon i : weapon) {
			System.out.printf("%d)   %-8s%10d%11d\n",i.getId(),i.getName(),i.getDamage(),i.getCost());
		}
	}
	public void buy() {
		
	}
	public int getIsItFirst() {
		return isItFirst;
	}
	public void setIsItFirst(int isItFirst) {
		this.isItFirst = isItFirst;
	}
}
