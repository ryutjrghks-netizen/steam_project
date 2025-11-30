package Monsters;

import Steam_project.Character;
import Steam_project.Monster;

public class Goblin extends Monster {
	private int poisonDamage = 1;
	
	
	public Goblin() {
		super("고블린", 20, 5, 10, "고블린");
	}

	@Override
	public void attack(Character target) {
		super.attack(target);
		
		if (target.isAlive()) {
			System.out.println("고블린의 독에 중독되었다!");
			System.out.println(poisonDamage + " 데미지를 입었다!\n");
			target.hp -= poisonDamage;
			poisonDamage += 1;
		}
	}
		
	

}
