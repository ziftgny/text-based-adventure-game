package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	private Scanner input = new Scanner(System.in);
	private int damage;
	private int health;
	private int money;
	private String name;
	private String className;


	void selectClass() {
		GameClass[] classes = {new Samurai(),new Archer(),new Knight()};
		System.out.println("Select your class!");
		System.out.println("  CLASS     DAMAGE     HEALTH     MONEY");
		for (GameClass i : classes) {
			System.out.printf("%d)%-8s%8d%11d%10d\n",i.getId(),i.getName(),i.getDamage(),i.getHealth(),i.getMoney());
		}
	//  IMPORTANT CODE-------------------------------	
		int classInput = 0;
		do {	
				if(!input.hasNextInt())
				{
					System.out.println("enter valid values");
					input.nextLine();
					continue;
				}
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
				input.nextLine();				
		}while (!(classInput>=1 && classInput<=3));
		
	//------------------------------------------------------------
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
