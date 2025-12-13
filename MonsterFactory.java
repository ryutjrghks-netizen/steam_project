package Steam_project;

import java.util.Random;
import Steam_project.object.*;
import Steam_project.monsters.*;

public class MonsterFactory {
	private static Random random = new Random();
	
	public static Monster getRandomMonsterFirstFloor() {
		int chance = random.nextInt(100);	
		
		if (chance < 40) return new Goblin();									
		else if (chance < 50) return new Monster("홉고블린", 30, 5, 10, 10, 15);		
		else if (chance < 70) return new Wolf();							
		else if (chance < 80) return new Skeleton();							
		else if (chance < 90) return new Oak();									
		else return new Ghost();									
		
	}
	
	public static Monster getBossFirstFloor() {
		return new Troll();
	}
	
	public static Monster getSpecificMonster(String name) {		// 발표 시연 할 때, 특정 몬스터 생성을 위한 메서드
        String upperName = name.toUpperCase();
        
        switch (upperName) {
            case "TROLL":
            case "BOSS":
                return new Troll();
            case "GOBLIN":
                return new Goblin();
            case "OAK":
                return new Oak();
            case "WOLF":
                return new Wolf();
            case "SKELETON":
                return new Skeleton();
            case "GHOST":
                return new Ghost();
            case "HOBGOBLIN":
                return new Monster("홉고블린", 30, 5, 10, 10, 15);
            default:
                return null;
        }
    }
}