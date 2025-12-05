package Steam_project.object;

public class Character {
	protected String name;
	protected int hp;
	protected int damage;
	protected int speed;
	protected boolean isDefending;
	
	public Character(String name, int hp, int damage, int speed) {
		this.name=name;
		this.hp=hp;
		this.damage=damage;
		this.speed=speed;
		this.isDefending=false;
	}
	
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

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
	

}
