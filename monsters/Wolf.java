package Steam_project.monsters;

import Steam_project.object.Character;
import Steam_project.object.Monster;

public class Wolf extends Monster {
	public Wolf() {
		super("늑대", 35, 10, 10, 13, 40); 
	}	
		
	@Override
	public void attack(Character target) {
		if(Math.random() < 0.9 && target.isAlive() && !this.isDefending) {
			
			int rawBonusDamage = this.getDamage();
            int finalBonusDamage = rawBonusDamage;
            
            System.out.println("\n*** 늑대 특수 공격 발동! (추가 물기) ***");

            if (target.isDefending()) {
                int defenseValue = target.getDefense();
                finalBonusDamage -= defenseValue; 
                
                if (finalBonusDamage < 1) {
                    finalBonusDamage = 1; 
                }
                
                System.out.println("-> " + target.getName() + "이(가) 추가 공격에 대해 방어하여 피해를 " + target.getDefense() + "만큼 감소했습니다.");
            }
            
            target.takeDamage(finalBonusDamage);
            
            System.out.println("-> " + target.getName() + "이(가) 추가 공격으로 " + finalBonusDamage + "의 피해를 입었습니다.");
            
            if (!target.isAlive()) {
                System.out.println(target.getName() + "이(가) 연속 공격에 쓰러져 전투 불능 상태가 되었습니다.");
            }
		}
	}
}