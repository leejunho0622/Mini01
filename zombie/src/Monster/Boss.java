package Monster;

import java.util.Random;

import main.Unit;

public class Boss extends Unit{
	private int power;
	
	public Boss(int hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}
	
	public void attack(Unit player) {
		Random ran = new Random();
		power = ran.nextInt(this.level*5)+1;
		player.setHp(player.getHp() - power);
		if(player.getHp() < 0)
			player.setHp(0);
		
		System.out.println("보스가 "+power+"만큼 공격!");
	}
}
