package Steam_project.operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Steam_project.command.*;
import Steam_project.object.*;
import Steam_project.*;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, BattleCommand> playerCommands = new HashMap<>();
    private AttackCommand attackCommand;
    private DefendCommand defendCommand;
    private RunCommand runCommand;
    private int currentFloor = 1;
    
    private BattleManager battleManager;

    public GameManager() {
		attackCommand = new AttackCommand();
		defendCommand = new DefendCommand();
        runCommand = new RunCommand();

		playerCommands.put("1", attackCommand);
		playerCommands.put("2", defendCommand);
		playerCommands.put("3", runCommand);

		this.battleManager = new BattleManager(scanner, playerCommands, attackCommand, defendCommand);
	}

	public void startGame(Player player) {
        outer: while(player.isAlive()) {
        	System.out.println("\n--- 현재 층: " + currentFloor + "층 ---");
            printMenu(player);

            String option = scanner.nextLine().trim();

            switch(option) {
                case "1":
                    battleManager.startBattle(player,currentFloor);
                    currentFloor++;
                    break;
                case "4":
                    System.out.println("=================================");
                    System.out.println("     🛡️  모험을 포기하고 도주 시도  🛡️");
                    
                    Monster pursuingMonster = new Monster("추격하는 고블린", 30, 8, 5, 10, 30); 
                    
                    boolean runSuccess = runCommand.execute(player, pursuingMonster); 
                    
                    System.out.println("=================================");

                    if (runSuccess) {
                        System.out.println("세상을 등지고 도망쳤습니다. 게임을 종료합니다."); 
                        break outer;
                    } else {
                        System.out.println("도망에 실패하여 몬스터에게 붙잡혔습니다! 강제 전투가 시작됩니다.");
                        battleManager.startBattle(player,currentFloor);
                    }
                    break;
                default:
                	Monster monster = MonsterFactory.getSpecificMonster(option);
                    
                    if (monster != null) {
                        System.out.println("\n*** 연습 모드: [" + monster.getName() + "] 소환! ***");
                        Player practicePlayer = new Player(player.getName() + "(연습)");
                        battleManager.startBattle(practicePlayer, monster); 
                    } else {
                        System.out.println("잘못된 입력이거나 알 수 없는 몬스터 이름입니다.");
                    }
                    break;
            }
        }
    }

    private void printMenu(Player player) {
        System.out.println("---------------------------------");
        System.out.println("현재 체력: " + player.getHp());
        System.out.println("1.전투 개시 | 4.도망");
        System.out.println("---------------------------------");
        System.out.print("행동 선택> ");
    }

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
    
    

}