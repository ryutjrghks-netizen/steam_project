package Steam_project;

import java.util.Scanner;

public class GameManager {
	private int turn = 1;
	
    private Scanner scanner = new Scanner(System.in);
    private BattleManager battleManager = new BattleManager();

    public void startGame(Player player) {
        outer: while(player.isAlive()) {
            printMenu(player);

            String option = scanner.nextLine();

            switch(option) {
                case "1":
                    battleManager.startBattle(player);
                    turn += 1;
                    break;
                
                case "2":
                	player.rest(player.maxHp / 3);
                	turn += 1;
                	break;
                	
                case "4":
                    System.out.println("도망쳤습니다..");
                    turn += 1;
                    break outer;
            }
        }
    }

    private void printMenu(Player player) {
        System.out.println("----------------------------------------");
        System.out.println("현재 " + this.turn + "층에 있습니다.");
        System.out.println("남은 체력: " + player.getHp() + " / " + player.getMaxHp() + " | 공격력: " + player.getDamage());
        System.out.println("레벨: " + player.getLevel() + " | 경험치: " + player.getExp() + " / 100");
        System.out.println("----------------------------------------");
        System.out.println("1.나아가기 | 2. 휴식하기 | 4.도주");
        System.out.println("----------------------------------------");
        
        System.out.print("행동 선택> ");
    }

}
