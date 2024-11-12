package main;

import java.util.Random;

abstract public class Monster extends Unit implements Name {
	protected Random ran = new Random();
	protected int monsterPower;
	protected int armor;
	protected int damage;

	protected Monster(double hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}

}
