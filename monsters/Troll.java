package Steam_project.monsters;

import Steam_project.object.*;
import Steam_project.object.Character;

public class Troll extends Monster {
	private boolean isEnraged = false;
	
	public Troll() {
		super("트롤", 50, 10, 20, 20, 50);	}	
		
	@Override
	public void attack(Character target) {
        
		if (this.getHp() < 25 && !isEnraged) { 
			System.out.println("10층의 지배자 트롤이 분노했습니다!");
            
            this.setDamage(this.getDamage() + 20); 
            
            this.isEnraged = true; 
            
			System.out.println("트롤의 공격력이 20 올랐습니다! (현재 공격력: " + this.getDamage() + ")");
		}
		super.attack(target); 
	}
}