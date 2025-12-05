package Steam_project;

import java.util.Scanner;

import Steam_project.object.Player;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("---------------------------------");
		System.out.println("      ✨ 턴제 RPG 게임 시작 ✨");
		System.out.println("---------------------------------");
		
		System.out.print("플레이어 이름을 작성하세요: ");
		String name = scanner.nextLine();
		
		// 1. 플레이어 생성 (기본 Speed 10)
		Player player = new Player(name);
		
		System.out.println("\n>> " + player.getName() + "님, 게임을 시작합니다.");
		System.out.println("   [초기 능력치] HP: " + player.getHp() + 
				" | DMG: " + player.getDamage() + 
				" | SPD: " + player.getSpeed());
		
		// 2. 게임 관리자 및 커맨드 객체 초기화 (GameManager 생성자에서 처리됨)
		GameManager gm = new GameManager();
		
		// 3. 게임 시작
		gm.startGame(player);
		
		System.out.println("\n---------------------------------");
		System.out.println("      게임 종료. 수고하셨습니다!");
		System.out.println("---------------------------------");
		
		scanner.close();
	}
}