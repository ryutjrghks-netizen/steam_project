package Steam_project.monsters;

import Steam_project.object.*;
import Steam_project.object.Character;

public class Skeleton extends Monster {
	public Skeleton() {
		super("스켈레톤", 25, 15, 15, 5, 35);
	}	
		
	@Override
	public void attack(Character target) {
        int specialDamage = this.getDamage() / 2;
        
		if (target.isAlive()) {
			System.out.println("스켈레톤이 " +"갈비뼈를 뽑아 휘둘렀다! (피해량: " + specialDamage + ")");
            
			target.takeDamage(specialDamage);
           
            if (target.isAlive()) {
                System.out.println(target.getName() + "의 남은 체력: " + target.getHp());
            } else {
                System.out.println(target.getName() + "이(가) 스켈레톤의 공격으로 쓰러졌습니다.");
            }
		}
	}
}