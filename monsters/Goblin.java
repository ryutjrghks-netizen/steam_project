package Steam_project.monsters;
import Steam_project.object.*;
import Steam_project.object.Character;

public class Goblin extends Monster {
	
	public Goblin() {
		super("고블린", 20, 5, 5, 10, 10);
	}

	@Override
	public void attack(Character target) {
	    
	    if (target.getPoisonTurnsLeft() == 0) {
	        
	        
	        int randomTurns = 1 + (int)(Math.random() * 3); 
	        
	        target.setPoisonTurnsLeft(randomTurns);
	        target.setPoisonDamagePerTurn(1);
	        
	        System.out.println(target.getName() + "이(가) " + randomTurns + "턴 동안 독에 감염되었습니다!");
	    }

	}
}