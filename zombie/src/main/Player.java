package main;

import java.util.Random;

abstract public class Player extends Unit {
	protected Random ran = new Random();
	protected int playerPower;
	protected int armor;
	protected int damage;

	protected Player(double hp, int mp, int level, int exp, int position) {
		super(hp, mp, level, exp, position);
	}
}
