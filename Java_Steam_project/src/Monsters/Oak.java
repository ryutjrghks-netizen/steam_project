package Monsters;

import Steam_project.Character;
import Steam_project.Monster;

public class Oak extends Monster {
	
	public Oak() {
		super("오크", 40, 10, 20, 35);
	}
	
	@Override
	public void attack(Character target) {
		if(Math.random() < 0.3) {
			System.out.println("오크가 분노에 차올랐다!");
			System.out.println("오크의 공격력이 5 증가했다!");
			this.damage += 5;
		}
		super.attack(target);
		
	}
	

}
