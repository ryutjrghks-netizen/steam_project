package Monsters;

import Steam_project.Character;
import Steam_project.Monster;

public class Skeleton extends Monster {
	
	
	public Skeleton() {
		super("스켈레톤", 15, 0, 15, 20);
	}

	@Override
	public void attack(Character target) {
		super.attack(target);
		
		if (target.isAlive()) {
			System.out.println("스켈레톤이 갈비뼈를 뽑아 휘둘렀다!\n");
			target.takeDamage(damage / 2);
			
		}
	}
		
	

}
