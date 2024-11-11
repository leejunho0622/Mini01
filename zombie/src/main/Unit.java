package main;

abstract public class Unit {
	private double hp;
	private int mp;
	private int level;
	private int exp;
	private int position;

	public Unit(int hp, int mp, int level, int exp, int position) {
		this.hp = hp;
		this.mp = mp;
		this.level = level;
		this.exp = exp;
		this.position = position;
	}

	public void setPos(int position) {
		this.position = position;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void levelUP() {
		this.level++;
	}

	public int getPos() {
		return this.position;
	}

	public double getHp() {
		return this.hp;
	}

	public int getMp() {
		return this.mp;
	}

	public int getLevel() {
		return this.level;
	}
	
	public int getexp() {
		return this.exp;
	}
	
	public void move() {
		
	}
}
