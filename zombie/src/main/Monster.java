package main;

import java.util.Random;

abstract public class Monster extends Unit{
	protected Random ran = new Random();
	protected int MonsterPower;
	protected int armor;
	protected int damage;
	
	protected Monster(int hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}
	
}
