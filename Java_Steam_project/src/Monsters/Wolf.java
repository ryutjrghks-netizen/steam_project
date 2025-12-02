package Monsters;

import Steam_project.Character;
import Steam_project.Monster;

public class Wolf extends Monster {
	
	public Wolf() {
		super("늑대", 35, 5, 10, 25);
	}
	
	@Override
	public void attack(Character target) {
		super.attack(target);
		
		if(Math.random() < 0.3 && target.isAlive()) {
			System.out.println("늑대가 연속으로 베어물었다!");
			super.attack(target);
		}
	}
	

}
