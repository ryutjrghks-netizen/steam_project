package Monsters;

import Steam_project.Character;
import Steam_project.Monster;

public class Troll extends Monster {
	public Troll() {
		super("트롤", 50, 10, 20, 50);
	}
	
	@Override
	public void attack(Character target) {
		if (hp < 25) {
			System.out.println("1층의 지배자가 분노했습니다!");
			this.damage += 20;
			System.out.println("트롤의 공격력이 20 올랐습니다!");
		}
		super.attack(target);
		
		
	}
}
