package Steam_project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		GameManager gm = new GameManager();
		
		System.out.println("선형적인 던전을 탐험하며 몬스터들을 처치하고 승리를 쟁취하세요!");
		
		System.out.print("플레이어 이름: ");
		String name = scanner.nextLine();
		
		Player player = new Player(name, 100, 15);
		
		
		
		gm.startGame(player);
	}
}
