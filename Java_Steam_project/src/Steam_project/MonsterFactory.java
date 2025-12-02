package Steam_project;

import java.util.Random;

import Monsters.Ghost;
import Monsters.Goblin;
import Monsters.Oak;
import Monsters.Skeleton;
import Monsters.Troll;
import Monsters.Wolf;

public class MonsterFactory {
	private static Random random = new Random();
	
	public static Monster getRandomMonster() {
		int num = random.nextInt(6);		// 6종류 몬스터
		
		switch(num) {
			case 0:
				return new Goblin();
			case 1:
				return new Monster("홉고블린", 30, 5, 10, 15);
			case 2:
				return new Wolf();
			case 3:
				return new Skeleton();
			case 4:
				return new Oak();
			case 5:
				return new Troll();
			default:
				return new Ghost();
		}
	}
}
