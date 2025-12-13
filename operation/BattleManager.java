package Steam_project.operation;

import java.util.Map;
import java.util.Scanner;
import Steam_project.command.*;
import Steam_project.*;
import Steam_project.operation.*;
import Steam_project.object.*;
import Steam_project.object.Character;


public class BattleManager {
    
    private Scanner scanner; 
    private Map<String, BattleCommand> playerCommands;
    private AttackCommand attackCommand;
    private DefendCommand defendCommand;

    public BattleManager(Scanner scanner, Map<String, BattleCommand> playerCommands, 
                         AttackCommand attackCommand, DefendCommand defendCommand) {
        this.scanner = scanner;
        this.playerCommands = playerCommands;
        this.attackCommand = attackCommand;
        this.defendCommand = defendCommand;
    }
    
public void startBattle(Player player, Monster monster) {		// 연습 모드에서의 전투 로직, 밑에 startBattle과 같은데 매개변수에 대상 몬스터가 포함됨
    	
        System.out.println("전투 개시");
        System.out.println("\n---------------[" + monster.getName() + "]가 나타났다!---------------\n");
        
        player.setDefending(false);
        
        while(player.isAlive() && monster.isAlive()) {
            
            processPoisonEffect(player);
            if (!player.isAlive()) { break; }
            

        	String playerActionType = executePlayerTurn(player, monster);
        	
        	if(playerActionType.equals("RunSuccess")) {
        		break;
        	}
            if(playerActionType.equals("Invalid")) {
                continue; 
            }
            
        	BattleCommand monsterAction = executeMonsterTurn(player, monster);
            
            resolveRound(player, monster, playerActionType, monsterAction);
            
        }
        if (player.isAlive()) {
            System.out.println("\n-------------------------------------");
            System.out.println(monster.getName() + "을(를) 물리쳤습니다!");
            System.out.println("-------------------------------------\n");
        } else if (monster.isAlive()){
            System.out.println("\n-------------------------------------");
            System.out.println(player.getName() + "은(는) " + monster.getName() + "에게 패배했습니다...");
            System.out.println("GAME OVER");
            System.out.println("-------------------------------------\n");
        }
    }

    public void startBattle(Player player, int floor) {
    	
    	Monster monster;
    	if (floor % 10 == 0) {
            System.out.println("\n*** 10층 보스 트롤 등장! ***");
            monster = MonsterFactory.getSpecificMonster("Troll");
        } else {
        	monster = MonsterFactory.getRandomMonsterFirstFloor(); 	// 무작위 몬스터 생성
        }
    	
    	
		
        System.out.println("전투 개시");
        System.out.println("\n---------------적이 나타났다!---------------\n");
        System.out.println(monster.getName() + " (HP: " + monster.getHp() + ", Speed: " + monster.getSpeed() + ")");

        player.setDefending(false);
        
        while(player.isAlive() && monster.isAlive()) {
        	
        	processPoisonEffect(player);
            if (!player.isAlive()) { break; }
            
            
        	String playerActionType = executePlayerTurn(player, monster);
        	
        	if(playerActionType.equals("RunSuccess")) {
        		break;
        	}
        	
        	BattleCommand monsterAction = executeMonsterTurn(player, monster);
            
        	if (playerActionType.equals("Invalid") || playerActionType.equals("RunFail")) {
                System.out.println("플레이어는 행동을 놓쳤습니다. 몬스터가 행동합니다.");
                resolveSingleAction(monsterAction, monster, player); 
                
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
    
    private void processPoisonEffect(Character target) {
        int turnsLeft = target.getPoisonTurnsLeft();
        int currentDamage = target.getPoisonDamagePerTurn();
        
        if (turnsLeft > 0) {
            System.out.println("\n--- 독 피해 적용: " + target.getName() + " ---");
            System.out.println(target.getName() + "은(는) " + currentDamage + "의 독 피해를 입었습니다.");
            
            target.takeDamage(currentDamage); 
            
            target.setPoisonDamagePerTurn(currentDamage + 1);
            target.setPoisonTurnsLeft(turnsLeft - 1);        
            
            if (target.isAlive()) {
                if (target.getPoisonTurnsLeft() > 0) {
                    System.out.println("독은 이제 " + target.getPoisonTurnsLeft() + "턴 남았으며, 다음 피해는 " + target.getPoisonDamagePerTurn() + "입니다.");
                } else {
                    System.out.println("독 효과가 해제되었습니다.");
                }
            } else {
                System.out.println(target.getName() + "이(가) 독으로 인해 사망했습니다!");
            }
        }
    }

	private String executePlayerTurn(Player player, Monster monster) {
        System.out.println("\n-----------------");
        System.out.println(player.getName() + " (HP: " + player.getHp() + ") | " + monster.getName() + " (HP: " + monster.getHp() + ")");
        System.out.println("1.공격 | 2.방어 | 3.도주");
        System.out.print("행동 선택> ");
        
        String battleOption = scanner.nextLine().trim();

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
	
    private void resolveSingleAction(BattleCommand action, Character attacker, Character target) {
        action.execute(attacker, target);
    }
	
	private void resolveRound(Player player, Monster monster, String playerActionType, BattleCommand monsterAction) {
	        
        String monsterActionType = (monsterAction instanceof AttackCommand) ? "1" : "2"; 
        BattleCommand playerAction = playerCommands.get(playerActionType);
        
	    if (playerActionType.equals("1") && monsterActionType.equals("1")) {
            System.out.println("\n*** 쌍방 공격! ***");
            if (player.getSpeed() >= monster.getSpeed()) {
                playerAction.execute(player, monster); 
                if (monster.isAlive() && player.isAlive()) {
                    monsterAction.execute(monster, player);
                }
            } else {
                monsterAction.execute(monster, player); 
                if (player.isAlive() && monster.isAlive()) {
                    playerAction.execute(player, monster);
                }
            }
            return;
        }

        if (playerActionType.equals("2") && monsterActionType.equals("2")) {
            System.out.println("\n*** 쌍방 방어! ***");
            if (player.getSpeed() >= monster.getSpeed()) {
                playerAction.execute(player, monster);
                monsterAction.execute(monster, player);
            } else {
                monsterAction.execute(monster, player);
                playerAction.execute(player, monster);
            }
            return;
        }

        if (playerActionType.equals("2") && monsterActionType.equals("1")) {
            System.out.println("\n*** 공격 vs 방어! (Player 방어) ***");
            playerAction.execute(player, monster);
            monsterAction.execute(monster, player);
            return;
        }
        
        if (playerActionType.equals("1") && monsterActionType.equals("2")) {
            System.out.println("\n*** 공격 vs 방어! (Monster 방어) ***");
            monsterAction.execute(monster, player);
            playerAction.execute(player, monster);
            return;
        }
	}
}