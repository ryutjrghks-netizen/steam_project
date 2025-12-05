package Steam_project.command;

import Steam_project.object.Monster;
import Steam_project.object.Player;
import Steam_project.object.Character;

public class RunCommand implements BattleCommand{

	@Override
	public boolean execute(Character player, Character monster) {
		System.out.println("\n--- 도주 ---");
		
		int playerSpeed=player.getSpeed();
		int monsterSpeed=monster.getSpeed();
		
		double baseChance=(double)playerSpeed/(playerSpeed+monsterSpeed);
		
		double runChance=Math.min(0.8, Math.max(0.2, baseChance));
		
		if(Math.random()<runChance) {
			System.out.println("도주에 성공했습니다! 전투를 종료합니다.");
			return true;
		} else {
			System.out.println("도주에 실패했습니다. 턴이 넘어갑니다.");
			return false;
		}
	}
	
	
}
