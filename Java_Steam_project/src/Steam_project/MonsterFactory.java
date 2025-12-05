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
	
	public static Monster getRandomMonsterFirstFloor() {
		int chance = random.nextInt(100);		// 0 ~ 99		
		
		if (chance < 40) return new Goblin();									//40%
		else if (chance < 50) return new Monster("홉고블린", 30, 5, 10, 15);		//10%
		else if (chance < 70) return new Wolf();								//20%
		else if (chance < 80) return new Skeleton();							//10%
		else if (chance < 90) return new Oak();									//10%
		else return new Ghost();												//5%
		
	}
	
	public static Monster getBossFirstFloor() {
		return new Troll();
	}
}
