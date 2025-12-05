package Steam_project.object;

public class Monster extends Character{
	private int expOffer;
	
	public Monster(String name, int hp, int damage,int speed, int expOffer) {
		super(name, hp, damage,speed);
		this.expOffer=expOffer;
	}
	
	public int getExpOffer() {
		return expOffer;
	}

}
