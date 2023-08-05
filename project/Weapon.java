package project;

public  class Weapon {
	private int id;
	private String name; 
	private int damage;
	private int cost;
	public Weapon(int id,String name,  int damage, int cost) {
		super();
		this.name = name;
		this.id = id;
		this.damage = damage;
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
