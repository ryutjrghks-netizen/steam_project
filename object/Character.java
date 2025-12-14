package Steam_project.object;

import java.util.Random;

public class Character {
	protected String name;
	protected int hp;
	protected int damage;
	protected int defense;
	public int maxHp;
	protected int preHp;
	protected int originalDamage;

	protected int speed;
	protected boolean isDefending;
	private int poisonTurnsLeft = 0;

	private Random rand = new Random();

	public Character(String name, int maxHp, int damage, int defense, int speed) {
		this.name=name;
		this.hp=maxHp;
		this.maxHp=maxHp;
		this.damage=damage;
		this.defense=defense;
		this.speed=speed;
		this.isDefending=false;
	}

	public void rest(int healAmount){
		hp += healAmount;
		if (hp > maxHp){
			hp = maxHp;
		}
		System.out.printf("%s이(가) 휴식하여 체력을 %d 회복하였습니다! (현재 체력: %d / %d)\n", name, healAmount, hp, maxHp);
	}

	public int calcDamage(){					// 공격력 +-3의 랜덤 데미지
		int min = damage - 3;
		int max = damage + 3;
		
		return rand.nextInt(max - min + 1) + min;
	}


    public int getPoisonTurnsLeft() {
		return poisonTurnsLeft;
	}

	public void setPoisonTurnsLeft(int poisonTurnsLeft) {
		this.poisonTurnsLeft = poisonTurnsLeft;
	}

	public int getPoisonDamagePerTurn() {
		return poisonDamagePerTurn;
	}

	public void setPoisonDamagePerTurn(int poisonDamagePerTurn) {
		this.poisonDamagePerTurn = poisonDamagePerTurn;
	}

	private int poisonDamagePerTurn = 0;
	
	public boolean isAlive() {
		return hp>0;
	}
	
	public void takeDamage(int damage) {
		this.hp -= damage;
	}
	
	public void setDefending(boolean isDefending) {
		this.isDefending=isDefending;
	}
	
	public boolean isDefending() {
		return isDefending;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public int getMaxHP(){
		return maxHp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
	

}
