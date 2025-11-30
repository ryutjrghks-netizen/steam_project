package Steam_project;

import java.util.Random;

public class MonsterFactory {
	private static Random random = new Random();
	
	public static Monster getRandomMonster() {
		int num = random.nextInt(6);		// 6종류 몬스터
		
		switch(num) {
			case 0:
				return new Monster("고블린", 20, 5, 10, "고블린");
			case 1:
				return new Monster("홉고블린", 30, 10, 15, "고블린");
			case 2:
				return new Monster("늑대", 35, 10, 25, "늑대");
			case 3:
				return new Monster("스켈레톤", 15, 15, 20, "해골");
			case 4:
				return new Monster("오크", 40, 20, 35, "오크");
			case 5:
				return new Monster("트롤", 50, 30, 50, "");
			default:
				return new Monster("고스트", 1, 1, 1, "");
			
		}
	}
}
