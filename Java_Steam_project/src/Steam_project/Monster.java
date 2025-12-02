package Steam_project;

public class Monster extends Character{
	private int expOffer;
	
	public Monster(String name, int hp, int shield, int damage, int expOffer) {
		super(name, hp, shield, damage);
		this.expOffer=expOffer;
	}
	
	public int getExpOffer() {
		return expOffer;
	}
	
	
}