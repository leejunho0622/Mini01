package main;

import Monster.*;
import Player.User;

public class Stage {
	private int stage;
	
	private User player;
	private Zombie zombie;
	private Skeleton skeleton;
	private Boss boss;
	
	public Stage(int stage) {
		this.stage = stage;
	}
	
	private void defaultEntity() {
		player = new User(200, 100, 1, 0, 0);
		zombie = new Zombie(100, 0, 1, 0, 3);
		skeleton = new Skeleton(50, 0, 1, 0, 5);
		boss = new Boss(400, 0, 5, 0, stage);
	}
	
	public void run() {
		defaultEntity();
	}
}
