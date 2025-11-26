package Steam_project;

public class Player extends Character{
	private int exp;
	private int level;
	
	public Player(String name, int hp, int damage) {
		super(name, 100, 20);
		this.exp=0;
		this.level=1;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void gainExp(int amount) {
		exp+=amount;
		if(exp>=100) {
			level++;
			exp-=100;
			damage+=5;
			hp+=20;
			System.out.println("레벨 업! 현재 레벨: "+level);
		}
	}

}