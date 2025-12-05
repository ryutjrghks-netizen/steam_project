package Steam_project.command;

import Steam_project.object.Monster;
import Steam_project.object.Player;
import Steam_project.object.Character;

public class DefendCommand implements BattleCommand{

	@Override
	public boolean execute(Character subject, Character object) {
		System.out.println("\n--- 방어 ---");
		subject.setDefending(true);
		System.out.println(subject.getName()+"이(가) 방어 태세를 갖춥니다.");
		return false;
	}
	
	

}
