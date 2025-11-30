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
	
	public void specialAttack(Player player) {
		switch(type) {
			case "고블린":
				goblinSpecial(player);
				break;
			case "늑대":
				wolfSpecial(player);
			
		}
	}
	
	private void goblinSpecial(Player player) {
		if(Math.random() < 0.2) {
			System.out.println("고블린이 독을 사용했다!" + player.name + " 의 공격력 5 감소!");
			player.damage -= 5;
			if (player.damage < 1) {
				player.damage = 1;
			}			
		}
	}
	
	private void wolfSpecial(Player player) {
		if(Math.random() < 0.1) {
			System.out.println("늑대가 연속으로 베어물었다!");
			player.takeDamage(this.damage / 2);
			System.out.println(name + " -> " + player.name + "에게 " + this.damage/2 + " 데미지!");
			
		}
	}

}