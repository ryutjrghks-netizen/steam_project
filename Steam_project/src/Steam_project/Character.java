package Steam_project;

public class Character {
	protected String name;
	protected int hp;
	protected int damage;
	
	public Character(String name, int hp, int damage) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
	}
	
	public boolean isAlive() {
		return hp>0;
	}
	
	public void attack(Character target) {
		System.out.println(name+"이(가) "+target.name+"을(를) 공격합니다.");
		System.out.println(Character.this.name + " -> " + target.name + "에게 " + Character.this.damage + " 데미지!");
		target.hp-=damage;
		if(target.isAlive()) {
			System.out.println(target.name+"의 남은 체력: "+target.hp);
		} else {
			System.out.println(target.name+"이(가) 사망하였습니다.");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getHp() {
		return hp;
		
	}

}