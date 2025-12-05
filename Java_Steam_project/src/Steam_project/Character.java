package Steam_project;

import java.util.Random;

public class Character {
	protected String name;
	public int hp;
	protected int damage;
	protected int maxHp;
	protected int shield;
	protected int preHp;
	
	private Random rand = new Random();
	
	public Character(String name, int maxHp, int shield, int damage) {
		this.name=name;
		this.hp=maxHp;
		this.maxHp=maxHp;
		this.shield = shield;
		this.damage=damage;
	}
	
	public void rest(int healAmount) {
		hp += healAmount;
		if (hp > maxHp){
			hp = maxHp;
		}
		System.out.println(name + " 이(가) 휴식하여 체력을 " + healAmount + " 회복하였습니다! (현재 체력: " + hp + " / " + maxHp + ")");
	}
	
	public boolean isAlive() {
		return hp > 0;
	}
	
	public int calcDamage() {					// 공격력의 +-3 랜덤 데미지
		int min = damage - 3;
		int max = damage + 3;
		
		return rand.nextInt(max - min + 1) + min;
	}
	
	public void attack(Character target) {
		int damage = calcDamage();				// 데미지 랜덤화
		target.preHp = target.hp;				// 데미지 받기 전 체력 저장
		
		System.out.println(name+"이(가) "+target.name+"을(를) 공격합니다.\n");
		System.out.println(Character.this.name + " -> " + target.name + "에게 " + damage + " 데미지!");
		
		target.hp -= (damage - target.shield);
		System.out.println("받은 데미지: " + damage + " - " + target.shield + " = " + (damage - target.shield));
		
		if (target.hp < 0) target.hp = 0;
		
		if(target.isAlive()) {
			System.out.println(target.name + "의 체력: " + target.preHp + " -> " + target.hp + "\n");
		} else {
			System.out.println(target.name + "의 체력: " + target.preHp + " -> " + target.hp + "\n");
			System.out.println(target.name + "이(가) 사망하였습니다.");
		}
	}
	
	public void takeDamage(int damage) {
		hp -= damage;
		System.out.println(damage + " 의 데미지를 받았습니다!\n");
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
	
	public int getShield() {
		return shield;
	}

}