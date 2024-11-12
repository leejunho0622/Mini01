package Player;

import java.util.Random;

import main.Unit;

public class User extends Unit{
	private int setPower;
	private int armor;
	private int power;
	
	public User(int hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}
	
	public void attack(Unit monster) {
		Random ran = new Random();
		setPower = ran.nextInt(this.level*2)+1;
		power = setPower - armor;
		if(power <= 0)
			power = 1;
		monster.setHp(monster.getHp() - power);
		if(monster.getHp() < 0)
			monster.setHp(0);
		
		System.out.println("[플레이어] > "+power+"만큼 공격!");
	}
	
	public void skill(int scroll, Unit monster) {
		if(scroll == 1 && this.mp > 10) {
			System.out.println("연속베기!");
			attack(monster);
			attack(monster);
			this.mp -= 10;
		}else if(scroll == 2 && this.mp > 30) {
			System.out.println("힐!");
			this.hp += 100;
		}else {
			System.out.println("마나가 없습니다.");
		}
			
	}
}
