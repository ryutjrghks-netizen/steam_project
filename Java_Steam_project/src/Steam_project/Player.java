package Steam_project;

public class Player extends Character{
	private int exp;
	private int level;
	private int originalDamage;
	
	public Player(String name, int maxHp, int shield, int damage) {
		super(name, maxHp, shield, damage);
		this.exp = 0;
		this.level = 1;
		this.originalDamage = damage;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void battleStart() {
		this.originalDamage = this.damage;
	}
	
	public void battleEnd() {
		this.damage = this.originalDamage;
	}
	
	public void gainExp(int amount) {
		exp += amount;
		if(exp>=100) {
			level++;
			exp -= 100;
			damage += 5;
			
			maxHp += 10;
			hp += 100;
			if (hp > maxHp) {
				hp = maxHp;
			}
			
			shield += 1;
			System.out.println("레벨 업! 현재 레벨: " + level + " 최대 체력 10, 공격력 5, 방어력 1 UP!");
		}
	}
	


}