package project;

import java.util.Scanner;

public class Player {
	private Scanner input = new Scanner(System.in);
	private Inventory inventory = new Inventory();
	private int damage;
	private int health;
	private int money;
	private String name;
	private String className;
//sa

	void selectClass() {
		int counter = 1;
		GameClass[] classes = {new Samurai(),new Archer(),new Knight()};
		System.out.println("Select your class!");
		System.out.println("  CLASS     DAMAGE     HEALTH     MONEY");
		for (GameClass i : classes) {
			System.out.printf("%d)%-8s%8d%11d%10d\n",counter,i.getName(),i.getDamage(),i.getHealth(),i.getMoney());
			counter++;
		}
		
		int classInput = 0;
		
		do {	
				classInput = input.nextInt();
			switch(classInput) {
			case 1:
				this.setClass(classes[0]);
				break;
			case 2:
				this.setClass(classes[1]);
				break;
			case 3:
				this.setClass(classes[2]);
				break;
			default:
				System.out.println("please enter valid values");
				break;
				}
		}while(classInput!=1 && classInput!=2 && classInput!=3);
		
	}
	
	public void setClass(GameClass gameClass) {
		this.setClassName(gameClass.getName());
		this.setDamage(gameClass.getDamage());
		this.setMoney(gameClass.getMoney());
		this.setHealth(gameClass.getHealth());
	}
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
