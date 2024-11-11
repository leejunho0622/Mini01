package Monster;

import java.util.Random;

import main.Unit;

public class Skeleton extends Unit{
	private int setPower;
	private int armor;
	private int power;
	
	public Skeleton(int hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}
	
	public void attack(Unit player) {
		Random ran = new Random();
		power = ran.nextInt(this.level*3)+1;
		power = setPower - armor;
		if(power <= 0)
			power = 1;
		player.setHp(player.getHp() - power);
		if(player.getHp() < 0)
			player.setHp(0);
		
		System.out.println("스켈레톤이 "+power+"만큼 공격!");
	}
}
