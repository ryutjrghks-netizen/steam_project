package Steam_project.command;

import Steam_project.object.Character;

public class RunCommand implements BattleCommand{

	@Override
	public boolean execute(Character player, Character monster) {
		System.out.println("\n--- 도주 ---");
		
		int playerSpeed=player.getSpeed();
		int monsterSpeed=monster.getSpeed();
		
		double baseChance=(double)playerSpeed/(playerSpeed+monsterSpeed);		// 몬스터와 플레이어의 스피드 차이에 따른 도주 확률
		
		double runChance=Math.min(0.8, Math.max(0.2, baseChance));			// 도주 실행 시, 결과
		
		if(Math.random()<runChance) {
			System.out.println("도주에 성공했습니다! 전투를 종료합니다.");
			return true;
		} else {
			System.out.println("도주에 실패했습니다. 턴이 넘어갑니다.");
			return false;
		}
	}
	
	
}
