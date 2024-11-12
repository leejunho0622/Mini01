package Player;

import main.Player;
import main.Unit;

public class User extends Player implements UserStats{
	public User(double hp, int mp, int level, int exp, int position) {
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
		
		if(this.mp >= UserStats.MAX_MP)
			this.mp = UserStats.MAX_MP;
		else 
			this.mp += 5;
		System.out.println("[플레이어] > "+damage+"만큼 공격!");
	}
	
	@Override
	public int getMaxHp() {
		return 20 + this.level * 10;
	}
	
	public void skill(int scroll, Unit monster) {
		if(scroll == 1 && this.mp >= 10) {
			this.mp -= 30;
			System.out.println("연속베기!");
			attack(monster);
			attack(monster);
		}else if(scroll == 2 && this.mp >= 30) {
			System.out.println("힐!");
			this.hp += 10;
			int maxHp = getMaxHp();
			if(this.hp >= maxHp)
				this.hp = maxHp;
			this.mp -= 30;
		}else if(scroll == 3 && this.mp >= 100) {
			System.out.println("필살기!");
			monster.setHp(monster.getHp() * 0.7);
			int count = ran.nextInt(this.level*10)+1;
			for(int i=0; i<count; i++)
				attack(monster);
			this.mp -= 100;
		}else {
			System.out.println("마나가 없습니다.");
		}
	}
}
