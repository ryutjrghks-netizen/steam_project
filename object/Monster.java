package Steam_project.object;

public class Monster extends Character{
	private int expOffer;
	protected int targetPoisonTurnsLeft = 0;      
    protected int targetPoisonDamagePerTurn = 0; 
    protected Character poisonedTarget = null;
	
	public Monster(String name, int hp, int damage,int defense, int speed, int expOffer) {
		super(name, hp, damage,defense,speed);
		this.expOffer=expOffer;
	}
	
	public void attack(Character target) {
		
	}
	
	public int getExpOffer() {
		return expOffer;
	}
	
	protected void applyPoisonEffect(Character target) {
        if (targetPoisonTurnsLeft > 0 && target.equals(this.poisonedTarget)) {
            System.out.println("\n--- 독 피해 적용: " + target.getName() + " ---");
            System.out.println(target.getName() + "은(는) " + targetPoisonDamagePerTurn + "의 독 피해를 입었습니다.");
            
            target.takeDamage(targetPoisonDamagePerTurn);
            
            this.targetPoisonDamagePerTurn += 1; // 독 데미지 1 증가
            this.targetPoisonTurnsLeft -= 1;     // 남은 턴 감소
            
            if (target.isAlive()) {
                if (targetPoisonTurnsLeft > 0) {
                    System.out.println("독은 이제 " + targetPoisonTurnsLeft + "턴 남았으며, 다음 피해는 " + targetPoisonDamagePerTurn + "입니다.");
                } else {
                    System.out.println("독 효과가 해제되었습니다.");
                    this.poisonedTarget = null;
                }
            } else {
                System.out.println(target.getName() + "이(가) 독으로 인해 사망했습니다!");
                this.poisonedTarget = null;
            }
        }
    }
}
