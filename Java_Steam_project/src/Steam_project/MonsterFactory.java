package Steam_project;

import java.util.Random;

public class MonsterFactory {
	private static Random random = new Random();
	
	public static Monster getRandomMonster() {
		int num = random.nextInt(6);		// 6종류 몬스터
		
		switch(num) {
			case 0:
				return new Monster("고블린", 30, 1, 1);
			case 1:
				return new Monster("늑대", 1, 1, 1);
			case 2:
				return new Monster("구울", 1, 1, 1);
			case 3:
				return new Monster("스켈레톤", 1, 1, 1);
			case 4:
				return new Monster("오크", 1, 1, 1);
			case 5:
				return new Monster("흡혈귀", 1, 1, 1);
			default:
				return new Monster("고스트", 1, 1, 1);
			
		}
	}
}
