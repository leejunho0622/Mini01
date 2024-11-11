package main;

abstract public class Unit {
	protected double hp;
	protected int mp;
	protected int level;
	protected int exp;
	protected int position;

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
	
	public void setExp(int exp) {
		this.exp = exp;
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
	abstract void attack(Unit Unit);
}
