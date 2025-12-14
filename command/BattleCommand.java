package Steam_project.command;

import Steam_project.object.Character;

public interface BattleCommand {
	
	boolean execute(Character subject, Character object);
	

}
