package Steam_project;

public class Monster extends Character{
	private int expOffer;
	private String type;
	
	public Monster(String name, int hp, int damage, int expOffer, String type) {
		super(name, hp, damage);
		this.expOffer=expOffer;
		this.type = type;
	}
	
	public int getExpOffer() {
		return expOffer;
	}
	
	
}