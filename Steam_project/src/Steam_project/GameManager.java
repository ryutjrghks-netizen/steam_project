package Steam_project;

import java.util.Scanner;

public class GameManager {
    private Scanner scanner = new Scanner(System.in);

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
            }
        }
    }

    private void printMenu(Player player) {
        System.out.println("-----------------------------------------");
        System.out.println("현재 체력: " + player.getHp());
        System.out.println("1.전투 개시 | 4.도주");
        System.out.println("-----------------------------------------");
        System.out.print("행동 선택> ");
    }

    private void startBattle(Player player) {
    	
		Monster monster = new Monster("고블린", 30, 8, 30);
		
        System.out.println("전투 개시");
        System.out.println("\n---------------적이 나타났다!---------------\n");

        while(player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (!monster.isAlive()) break;

            monster.attack(player);
        }

        System.out.println("\n-----------------전투 종료!-----------------\n");

        if (player.isAlive()) {
            System.out.println(player.getName() + "의 승리!");
            System.out.println("현재 남은 체력: " + player.getHp());
        } else {
            System.out.println("패배.");
        }
    }
}
