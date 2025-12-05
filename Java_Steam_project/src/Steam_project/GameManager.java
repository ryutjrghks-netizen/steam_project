package Steam_project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Steam_project.command.BattleCommand; 
import Steam_project.command.AttackCommand;
import Steam_project.command.DefendCommand;
import Steam_project.command.RunCommand;
import Steam_project.object.Monster;
import Steam_project.object.Player; 

public class GameManager {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, BattleCommand> playerCommands = new HashMap<>();
    private AttackCommand attackCommand;
    private DefendCommand defendCommand;
    private RunCommand runCommand;

    public GameManager() {
        attackCommand = new AttackCommand();
        defendCommand = new DefendCommand();
        runCommand = new RunCommand();

        playerCommands.put("1", attackCommand);
        playerCommands.put("2", defendCommand);
        playerCommands.put("3", runCommand);
    }

    public void startGame(Player player) {
        outer: while(player.isAlive()) {
            printMenu(player);

            String option = scanner.nextLine();

            switch(option) {
                case "1":
                    startBattle(player);
                    break;
                case "4":
                    System.out.println("도망쳤습니다..");
                    break outer;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void printMenu(Player player) {
        System.out.println("---------------------------------");
        System.out.println("현재 체력: " + player.getHp());
        System.out.println("1.전투 개시 | 4.도주");
        System.out.println("---------------------------------");
        System.out.print("행동 선택> ");
    }

    private void startBattle(Player player) {
    	
		Monster monster = new Monster("고블린", 300, 8, 5, 30);
		
        System.out.println("전투 개시");
        System.out.println("\n---------------적이 나타났다!---------------\n");
        System.out.println(monster.getName() + " (HP: " + monster.getHp() + ", Speed: " + monster.getSpeed() + ")");

        player.setDefending(false);
        
        while(player.isAlive() && monster.isAlive()) {
            
        	String playerActionType = executePlayerTurn(player, monster);
        	
        	if(playerActionType.equals("RunSuccess")) {
        		break;
        	}
        	
        	BattleCommand monsterAction = executeMonsterTurn(player, monster);
            
        	if (playerActionType.equals("Invalid") || playerActionType.equals("RunFail")) {
                System.out.println("플레이어는 행동을 놓쳤습니다. 몬스터가 행동합니다.");
                monsterAction.execute(monster, player);
                
            } else {
                resolveRound(player, monster, playerActionType, monsterAction);
            }
            
            if (!player.isAlive() || !monster.isAlive()) {
            	break;
            }
        }

        System.out.println("\n-----------------전투 종료!-----------------\n");
        
        if (player.isAlive()) {
            System.out.println(player.getName() + "의 승리!");
            player.gainExp(monster.getExpOffer()); 
            System.out.println("현재 남은 체력: " + player.getHp());
        } else {
            System.out.println("패배.");
        }
    }

	private String executePlayerTurn(Player player, Monster monster) {
        System.out.println("\n-----------------");
        System.out.println(player.getName() + " (HP: " + player.getHp() + ") | " + monster.getName() + " (HP: " + monster.getHp() + ")");
        System.out.println("1.공격 | 2.방어 | 3.도주");
        System.out.print("행동 선택> ");
        
        String battleOption = scanner.nextLine();

        BattleCommand command = playerCommands.get(battleOption);
        
        if (command == null) {
            System.out.println("잘못된 입력입니다.");
            return "Invalid";
        }

        if (battleOption.equals("3")) { 
            boolean runSuccess = command.execute(player, monster);
            if (runSuccess) {
                return "RunSuccess";
            }
            return "RunFail";
        }
        
        return battleOption;
    }
	
	private BattleCommand executeMonsterTurn(Player player, Monster monster) {
		int action = (int)(Math.random() * 2);

        if (action == 0) { 
            return attackCommand; 
        } else { 
            return defendCommand; 
        }
    }
	
	private void resolveRound(Player player, Monster monster, String playerActionType, BattleCommand monsterAction) {
	        
        String monsterActionType = (monsterAction instanceof AttackCommand) ? "1" : "2"; 
        
	    if (playerActionType.equals("1") && monsterActionType.equals("1")) {
            System.out.println("\n*** 쌍방 공격! ***");
            if (player.getSpeed() >= monster.getSpeed()) {
                attackCommand.execute(player, monster); 
                if (monster.isAlive() && player.isAlive()) {
                    monsterAction.execute(monster, player);
                }
            } else {
                monsterAction.execute(monster, player); 
                if (player.isAlive() && monster.isAlive()) {
                    attackCommand.execute(player, monster);
                }
            }
            return;
        }

        if (playerActionType.equals("2") && monsterActionType.equals("2")) {
            System.out.println("\n*** 쌍방 방어! ***");
            if (player.getSpeed() >= monster.getSpeed()) {
                defendCommand.execute(player, monster);
                monsterAction.execute(monster, player);
            } else {
                monsterAction.execute(monster, player);
                defendCommand.execute(player, monster);
            }
            return;
        }

        if (playerActionType.equals("2") && monsterActionType.equals("1")) {
            System.out.println("\n*** 공격 vs 방어! (Player 방어) ***");
            defendCommand.execute(player, monster);
            monsterAction.execute(monster, player);
            return;
        }

        if (playerActionType.equals("1") && monsterActionType.equals("2")) {
            System.out.println("\n*** 공격 vs 방어! (Monster 방어) ***");
            monsterAction.execute(monster, player);
            attackCommand.execute(player, monster);
            return;
        }
	}
}