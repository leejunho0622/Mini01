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
		monster.setHp(monster.getHp() - power);
		power = setPower - armor;
		if(power <= 0)
			power = 1;
		if(monster.getHp() < 0)
			monster.setHp(0);
		
		System.out.println("플레이어가 "+power+"만큼 공격!");
	}
}
