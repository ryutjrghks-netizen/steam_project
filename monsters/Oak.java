package Steam_project.monsters;
import Steam_project.object.*;
import Steam_project.object.Character;

public class Oak extends Monster {
	
	public Oak() {
		super("오크", 40, 20, 20, 10, 50);
	}

	@Override
	public void attack(Character target) {
		
        if(Math.random() < 0.3) {
        	this.damage += 5;
			System.out.println("오크가 분노에 차올랐다!");
			System.out.println("오크의 공격력이 5 증가했다!");
		}
	}
}
