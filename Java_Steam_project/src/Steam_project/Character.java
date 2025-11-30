package Steam_project;

public class Character {
	protected String name;
	protected int hp;
	protected int damage;
	protected int maxHp;
	protected int shield;
	
	public Character(String name, int maxHp, int damage) {
		this.name=name;
		this.hp=maxHp;
		this.maxHp=maxHp;
		this.damage=damage;
	}
	
	public void rest(int healAmount) {
		hp += healAmount;
		if (hp > maxHp){
			hp = maxHp;
		}
		System.out.println(name + " 이(가) 휴식하여 체력을 " + healAmount + " 회복하였습니다! (현재 체력: " + hp + " / " + maxHp);
	}
	
	public boolean isAlive() {
		return hp>0;
	}
	
	public void attack(Character target) {
		System.out.println(name+"이(가) "+target.name+"을(를) 공격합니다.\n");
		System.out.println(Character.this.name + " -> " + target.name + "에게 " + Character.this.damage + " 데미지!");
		target.hp-=damage;
		if(target.isAlive()) {
			System.out.println(target.name+"의 남은 체력: "+target.hp+"\n");
		} else {
			System.out.println(target.name+"이(가) 사망하였습니다.");
		}
	}
	
	public void takeDamage(int damage) {
		hp -= damage;
		System.out.println(damage + " 의 데미지를 받았습니다!");
	}
	
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getDamage() {
		return damage;
	}

}