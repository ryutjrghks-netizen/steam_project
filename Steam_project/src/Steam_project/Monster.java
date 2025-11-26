package Steam_project;

public class Monster extends Character{
	private int expOffer;
	
	public Monster(String name, int hp, int damage, int expOffer) {
		super(name, hp, damage);
		this.expOffer=expOffer;
	}
	
	public int getExpOffer() {
		return expOffer;
	}

}