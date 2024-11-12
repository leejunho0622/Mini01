package Player;

import main.Player;
import main.Unit;

public class User extends Player{
	public User(int hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}
	
	@Override
	public void attack(Unit monster) {
		playerPower = ran.nextInt(this.level*2)+1;
		armor = monster.getLevel()/2;
		damage = playerPower - armor;
		
		if(damage <= 0)
			damage = 1;
		monster.setHp(monster.getHp() - damage);
		if(monster.getHp() < 0)
			monster.setHp(0);
		
		this.mp += 10;
		System.out.println("[플레이어] > "+damage+"만큼 공격!");
	}
	
	public void skill(int scroll, Unit monster) {
		if(scroll == 1 && this.mp > 10) {
			System.out.println("연속베기!");
			attack(monster);
			attack(monster);
			this.mp -= 30;
		}else if(scroll == 2 && this.mp > 30) {
			System.out.println("힐!");
			this.hp += 100;
			this.mp -= 30;
		}else {
			System.out.println("마나가 없습니다.");
		}
			
	}
}
