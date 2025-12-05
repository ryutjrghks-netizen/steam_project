package Steam_project;

import java.util.Scanner;

public class BattleManager {

    private Scanner scanner = new Scanner(System.in);
    public GameManager gm;
        
    public BattleManager(GameManager gm) {
    	this.gm = gm;
    }
    
    public Monster makeMonster(int floor, int turn) {
    	Monster monster = null;
    	if (floor == 2 && turn == 0) {
    		monster = MonsterFactory.getBossFirstFloor();
    	}else if (floor == 1 && !(turn == 10)) {
    		monster = MonsterFactory.getRandomMonsterFirstFloor();
    	}
    	return monster;
    	
    }
    
    public void startBattle(Player player) {
    	
    	Monster monster = makeMonster(gm.floor, gm.turn);
    	
        System.out.println("\n전투 개시!");
        System.out.println("\n--------------------적이 나타났다!--------------------\n");
        System.out.println("▶ 나타난 몬스터: "+ monster.getName()+"\n");

        outer: while(player.isAlive() && monster.isAlive()) {
        	
            
        	System.out.println("적 남은 체력: " + monster.getHp() + " | 적의 공격력: " + (monster.getDamage() - 3) + " ~ " + (monster.getDamage() + 3));
            System.out.println("나의 남은 체력: " + player.getHp() + " | 나의 공격력: " + (player.getDamage() - 3) + " ~ " + (player.getDamage() + 3));
            System.out.println("--------------------------------------------------");
            System.out.println("1. 공격 | 2. 방어 | 3. 아이템 | 4. 도주");
            System.out.println("--------------------------------------------------");

            

            System.out.println("\n행동 선택> ");

            String battleOption = scanner.nextLine();

            switch(battleOption) {
                case "1":
                    player.attack(monster);
                    if (!monster.isAlive()) break;

                    monster.attack(player);
                    break;

                case "2":
                    System.out.println("방어 태세를 취했습니다. (아직 기능 없음)\n");
                    
                    monster.attack(player);
                    break;

                case "3":
                    System.out.println("아이템 사용 (아직 기능 없음)\n");
                    break;

                case "4":
                    System.out.println("\n도망쳤습니다.");
                    break outer;
            }
        }

        System.out.println("\n-----------------전투 종료!-----------------\n");
        
        player.battleEnd();
        
        if (player.isAlive() && !monster.isAlive()) {
            System.out.println(player.getName() + "의 승리!");
            System.out.println("현재 남은 체력: " + player.getHp());
            System.out.println("경험치 " + monster.getExpOffer() + " 획득!\n");
            player.gainExp(monster.getExpOffer());
        } else if(!player.isAlive() && monster.isAlive()) {
            System.out.println("여정이 끝을 맞았습니다..");
        } else {
            System.out.println("아무것도 얻지 못했습니다..\n");
        }
    }
}
