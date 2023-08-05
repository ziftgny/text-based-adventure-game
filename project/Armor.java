package project;

public  class Armor {
	private int id;
	private String name;
	private int ignore;
	private int cost;
	public Armor(int id, String name, int ignore, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.ignore = ignore;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIgnore() {
		return ignore;
	}
	public void setIgnore(int block) {
		this.ignore = block;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
