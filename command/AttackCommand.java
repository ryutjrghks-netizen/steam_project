package Steam_project.command;

import Steam_project.object.Character;
import Steam_project.object.Monster; // Monster 클래스 import

public class AttackCommand implements BattleCommand {

    @Override
    public boolean execute(Character attacker, Character target) {
        
        int damageToDeal = attacker.calcDamage();
        System.out.println(attacker.getName()+"의 공격!\n");
        
        if (target.isDefending()) {
            int defenseValue = target.getDefense();
            damageToDeal -= defenseValue; 
            
            if (damageToDeal < 1) {
                damageToDeal = 1; 
            }
            
            System.out.println(target.getName() + "이(가) 방어에 성공하여 방어력 " + defenseValue + "만큼 피해를 감소했습니다! (기본 공격)");
        }
        
        target.takeDamage(damageToDeal);
        System.out.println(attacker.getName() + "이(가) " + target.getName() + "에게 " + damageToDeal + "의 피해를 입혔습니다.");

        if (attacker instanceof Monster) {
            ((Monster)attacker).attack(target); 
        }
        
        target.setDefending(false);
        
        if (target.isAlive()) {
            System.out.println(target.getName() + "의 남은 체력: " + target.getHp());
        } else {
            System.out.println(target.getName() + "이(가) " + attacker.getName() + "의 공격에 쓰러졌습니다.");
        }
        
        
        return true; 
    }
}