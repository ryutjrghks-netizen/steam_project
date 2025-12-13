package Steam_project.command;

import Steam_project.object.*;
import Steam_project.object.Character;

public class AttackCommand implements BattleCommand{

	@Override
    public boolean execute(Character attacker, Character target) {
        if (attacker instanceof Monster) {			// 몬스터마다의 고유 공격을 활용하기 위한 조건문
            ((Monster)attacker).attack(target);
        }
        
        int damageToDeal = attacker.getDamage();
        if (target.isDefending()) {					// 수비 액션을 위한 조건문
            int defenseValue = target.getDefense();
            
            damageToDeal -= defenseValue; 
            
            System.out.println(target.getName() + "이(가) 방어에 성공하여 방어력 " + defenseValue + "만큼 피해를 감소했습니다!");
            
            if (damageToDeal < 1) {					// 방어력이 공격력보다 높을 경우 최소한의 데미지 피해
                damageToDeal = 1; 
                System.out.println("하지만 공격을 완전히 막지는 못하고 최소 피해 1을 입었습니다.");
            }
        }
        target.takeDamage(damageToDeal);
        
        target.setDefending(false);			// 수비 액션 초기화
        
        System.out.println(attacker.getName() + "이(가) " + target.getName() + "에게 " + damageToDeal + "의 피해를 입혔습니다. (총합)");
        
        return true;
    }
}
