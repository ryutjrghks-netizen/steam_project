package Steam_project.object;

public class Player extends Character{
	private int exp;
	private int level;
	
	public Player(String name) {
		super(name, 100, 20, 10, 10);
		this.exp=0;
		this.level=1;
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

	public int getExp() {
		return exp;
	}

	public int getLevel() {
		return level;
	}
		
}
