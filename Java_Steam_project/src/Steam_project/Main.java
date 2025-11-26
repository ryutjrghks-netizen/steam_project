package Steam_project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("플레이어 이름을 작성하세요: ");
		String name = scanner.nextLine();
		
		Player player = new Player(name, 50, 10);
		
		GameManager gm = new GameManager();
		gm.startGame(player);
	}
}
