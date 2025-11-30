package Steam_project;

import java.util.Scanner;

public class GameManager {
	private int turn;
	
    private Scanner scanner = new Scanner(System.in);
    private BattleManager battleManager = new BattleManager();

    public void startGame(Player player) {
        outer: while(player.isAlive()) {
            printMenu(player);

            String option = scanner.nextLine();

            switch(option) {
                case "1":
                    battleManager.startBattle(player);
                    break;
                
                case "2":
                	player.rest(player.maxHp / 3);
                	break;
                	
                case "4":
                    System.out.println("도망쳤습니다..");
                    break outer;
            }
        }
    }

    private void printMenu(Player player) {
        System.out.println("----------------------------------------");        
        System.out.println("현재 체력: " + player.getHp() + " / " + player.getMaxHp());
        System.out.println("현재 공격력: " + player.getDamage());
        System.out.println("현재 경험치: " + player.getExp() + " / 100");
        System.out.println("----------------------------------------");
        System.out.println("1.나아가기 | 2. 휴식하기 | 4.도주");
        System.out.println("----------------------------------------");
        
        System.out.print("행동 선택> ");
    }

}
