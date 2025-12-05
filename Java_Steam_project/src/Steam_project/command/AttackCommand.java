package Steam_project.command;

import Steam_project.GameManager;
import Steam_project.object.Character;
import Steam_project.object.Monster;
import Steam_project.object.Player;

public class AttackCommand implements BattleCommand{

	@Override
	public boolean execute(Character subject, Character object) {
		System.out.println("\n--- 공격 ---");
		
		int damageToDeal=subject.getDamage();
		
		
		System.out.println(subject.getName()+"이(가) "+object.getName()+"을(를) 공격합니다.");
		
		if(object.isDefending()) {
			damageToDeal /= 2;
			System.out.println(object.getName()+"의 방어 성공 (받은 피해: "+damageToDeal+")");
			object.setDefending(false);
		}
		
		object.takeDamage(damageToDeal);
		
		if(object.isAlive()) {
			System.out.println(object.getName()+"의 남은 체력: "+object.getHp());
		} else {
			System.out.println(object.getName()+"이(가) 사망하였습니다.");
		}
		
		return false;
	}
}
