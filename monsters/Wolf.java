package Steam_project.monsters;

import Steam_project.object.*;
import Steam_project.object.Character;

public class Wolf extends Monster {
	public Wolf() {
		super("늑대", 35, 5, 10, 10, 25);
	}	
		
	@Override
	public void attack(Character target) {
		super.attack(target);
		
		if(Math.random() < 0.4 && target.isAlive() && this.isDefending==false) {
			System.out.println("늑대가 분노하여 연속으로 베어물었습니다!");
            
			super.attack(target);
            
            if (target.isAlive()) {
                System.out.println(target.getName() + "의 남은 체력: " + target.getHp());
            } else {
                System.out.println(target.getName() + "이(가) 연속 공격에 쓰러졌습니다.");
            }
		}
	}
}