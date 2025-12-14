package Steam_project.operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Steam_project.command.*;
import Steam_project.object.*;
import Steam_project.*;
import Steam_project.object.Character;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, BattleCommand> playerCommands = new HashMap<>();
    private AttackCommand attackCommand;
    private DefendCommand defendCommand;
    private RunCommand runCommand;
    private int currentFloor = 1;
    private int turn = 1;
    
    
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
            System.out.println("\n────────────────────────────────────────────────────────────────────────────────────────────");
        	
            if (currentFloor == 10){
                System.out.println(" 10층에 도달했습니다.");
                System.out.println(" 심상치 않은 기운이 느껴집니다..");
                System.out.println(" 충분히 준비된 자만이 이 앞을 넘어설 수 있습니다.");
            }else{
                System.out.println(" 현재 " + currentFloor + "층을 탐험하고 있습니다. (" + turn + " / 3)");
            }

            printMenu(player);

            String option = scanner.nextLine().trim();

            switch(option) {

                case "1":
                    System.out.println("전투 개시\n");
                    battleManager.startBattle(player,currentFloor);
                    turn++;
                    if (turn > 3){
                        currentFloor++;
                        turn=1;
                        System.out.println("다음 층으로 올라갑니다.");
                    }
                    
                    break;

                case "2":
                    System.out.println("휴식\n");
                    player.rest(player.maxHp / 3);
                    turn++;
                    if (turn > 3){
                        currentFloor++;
                        turn=1;
                        System.out.println("\n다음 층으로 올라갑니다.");
                    }
                    break;

                case "3":
                    System.out.println("올라가기\n");
                    currentFloor++;
                    turn=1;
                    System.out.println("다음 층으로 올라갑니다.");
                    break;

                case "4":
                    System.out.println("도망치기\n");
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
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.printf(" 남은 체력: %d / %d │ 공격력: %d ~ %d │ 방어력: %d │ 속도: %d │ 다음 레벨업까지 %d 경험치 \n", player.getHp(), player.getMaxHP(), player.getDamage()-3, player.getDamage()+3, player.getDefense(), player.getSpeed(), 100-player.getExp());
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("┌──────────────────────────────────────────────────┐");
        System.out.println("│ 1.전투 개시 │ 2. 휴식 │ 3. 올라가기 │ 4.도망치기 │");
        System.out.println("└──────────────────────────────────────────────────┘");
        System.out.print("행동 선택> ");
    }

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
    
    

}