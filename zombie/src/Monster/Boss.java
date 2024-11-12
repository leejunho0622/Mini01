package Monster;

import main.Monster;
import main.Unit;

public class Boss extends Monster {
	public String name;

	public Boss(int hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}

	@Override
	public void attack(Unit player) {
		monsterPower = ran.nextInt(this.level * 5) + 1;
		armor = player.getLevel() / 2;
		damage = monsterPower - armor;

		if (damage <= 0)
			damage = 1;
		player.setHp(player.getHp() - damage);
		if (player.getHp() < 0)
			player.setHp(0);

		System.out.println("[보스] > " + damage + "만큼 공격!");
	}

	@Override
	public String setName() {
		name = Boss.prefix[ran.nextInt(prefix.length)] + " 보스";
		return name;
	}
}
