package Steam_project.object;

public class Player extends Character{
	private int exp;
	private int level;
	
	public Player(String name) {
		super(name, 60, 20, 10, 10);
		this.exp=0;
		this.level=1;
	}
	
	public void gainExp(int amount) {
		exp+=amount;
		System.out.printf("경험치를 %d 얻었습니다.\n", amount);
		if(exp>=100) {
			level++;
			exp-=100;
			damage+=5;
			maxHp+=20;
			hp+=100;
			speed+=2;
			if(hp>maxHp){
				hp=maxHp;
			}
			System.out.println("레벨 업! 현재 레벨: "+level+" 최대 체력 20, 공격력 5, 방어력 1, 스피드 2 UP!");
		}
		int levelupExp = 100 - exp;
		System.out.printf("다음 레벨업까지 필요한 경험치: %d\n", levelupExp);
		
	}

				

	public int getExp() {
		return exp;
	}

	public int getLevel() {
		return level;
	}
		
}
