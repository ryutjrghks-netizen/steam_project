package Steam_project;

import java.util.Scanner;
import Steam_project.object.Player;
import Steam_project.operation.*;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---------------------------------");
		System.out.println("      ✨ 턴제 RPG 게임 시작 ✨");
		System.out.println("---------------------------------");
		
		System.out.print("당신의 이름을 입력하세요: ");
		
		String name = scanner.nextLine().trim(); 
		
		Player player = new Player(name);
		
		System.out.println("\n>> " + player.getName() + "이(가) 던전에 발을 들였습니다..");
		System.out.printf("   [초기 능력치] HP: %d | DMG: %d | DEF: %d | SPD: %d\n", 
				player.getHp(), player.getDamage(), player.getDefense(), player.getSpeed());
		
		GameManager gm = new GameManager();
		
		gm.startGame(player);
		
		System.out.println("\n---------------------------------");
		System.out.println("      게임 종료. 수고하셨습니다!");
		System.out.println("---------------------------------");
		
		scanner.close();
	}
}