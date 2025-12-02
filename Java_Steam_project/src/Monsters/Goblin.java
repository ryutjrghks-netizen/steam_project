package Monsters;

import Steam_project.Character;
import Steam_project.Monster;

public class Goblin extends Monster {
	private int poisonDamage = 1;
	
	
	public Goblin() {
		super("고블린", 20, 5, 5, 10);
	}

	@Override
	public void attack(Character target) {
		super.attack(target);
		
		if (target.isAlive()) {
			System.out.println("고블린의 칼에 베였다!");
			System.out.println(poisonDamage + " 데미지를 입었다!\n");
			target.hp -= poisonDamage;
			poisonDamage += 1;
		}
	}
		
	

}
