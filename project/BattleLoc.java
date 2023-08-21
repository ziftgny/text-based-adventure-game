package project;

import java.util.Random;

public abstract class BattleLoc extends Location {
	
	public BattleLoc(Player player, String name) {
		super(player, name);
	}
	public void warning(){
		System.out.println("Leaving Safezone!!");
	}
	@Override
	public void onLocation() {
		
	}
	public  int battle(Obstacle[] obstacles) {
		for (Obstacle i : obstacles) {
			do {
				info(i);
				if(inputvalidator(i)==1) {
					return 1;
				}
				if(player.getHealth()<=0) {
					System.out.println("YOU ARE DEAD");
					return 3;
				}
			}while(i.getHealth()>0);
			System.out.println("Enemy has been defeated");
			System.out.println(i.getMoney()+" Gold has been gained");
			player.setMoney(player.getMoney()+i.getMoney());
		}
		System.out.println("Place has been cleared");
		return 0;
		
	}
	public void info(Obstacle obstacle) {
		System.out.println(obstacle.getName()+"  "+obstacle.getHealth());
		System.out.println("Your health : "+player.getHealth());
		System.out.println("Choose action!");
		System.out.println("1)Attack");
		System.out.println("2)Flee");
	}
	public int inputvalidator(Obstacle obstacle) {
		
		int battleinput = 0;
		do {
				if(!input.hasNextInt())
				{
					input.nextLine();
					System.out.println("enter valid values");
					continue;
				}
				battleinput=input.nextInt();
				input.nextLine();
				switch(battleinput) {
				case 1:
					obstacle.setHealth(obstacle.getHealth()-player.getDamage());
					System.out.println(player.getDamage()+" Damage has been dealt");
					if(player.getInventory().getEquippedArmor() != null){
						int damageReceived=(obstacle.damage-player.getInventory().getEquippedArmor().getIgnore());
						if(damageReceived<=0) {
							System.out.println("you received 0 damage");
						}
						else
						{
						player.setHealth(player.getHealth()-damageReceived);
						System.out.println("You received "+damageReceived+" damage");
						}
					}
					else
					{
						player.setHealth(player.getHealth()-obstacle.getDamage());
						System.out.println("you received "+obstacle.getDamage()+" damage");
					}
					
					
					break;
				case 2:
					Random rnd = new Random();
					if ((rnd.nextInt(100)+1)<=40) {
						return 1;
					}
					else
					{
						System.out.println("couldn't flee");
						if(player.getInventory().getEquippedArmor() != null){
							int damageReceived=(obstacle.damage-player.getInventory().getEquippedArmor().getIgnore());
							if(damageReceived<=0) {
								System.out.println("you received 0 damage");
							}
							else
							{
							player.setHealth(player.getHealth()-damageReceived);
							System.out.println("You received "+damageReceived+" damage");
							}
						}
						else
						{
							player.setHealth(player.getHealth()-obstacle.getDamage());
							System.out.println("you received "+obstacle.getDamage()+" damage");
						}
					}
					break;
				default:
					System.out.println("enter a valid value");
					break;
				}
				
		}while(!(battleinput>=1 && battleinput<=2));
		return 0;
	}
	

}
