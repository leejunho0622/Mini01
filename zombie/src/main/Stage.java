package main;

import java.util.Random;
import java.util.Scanner;

import Monster.*;
import Player.User;

public class Stage {
	private Random ran = new Random();
	private Scanner scan = new Scanner(System.in);

	private int stage;

	private User player;
	private Zombie zombie;
	private Skeleton skeleton;
	private Boss boss;

	private String name;

	public Stage(int stage) {
		this.stage = stage;
	}

	private void defaultEntity() {
		player = new User(20, 100, 1, 0, 0);
		zombie = new Zombie(10, 0, 1, 0, 3);
		skeleton = new Skeleton(5, 0, 1, 0, 5);
		boss = new Boss(40, 0, 3, 0, stage);
	}

	private void move() {
		player.setPos(player.getPos() + 1);
	}

	private void levelUp() {
		if (player.getExp() == 10) {
			System.out.println("=== Level UP  ===");
			System.out.printf("HP : %.1f -> %.1f\n", player.getHp(), player.getHp() + player.getHp() / 2);
			System.out.printf("MP : %d -> %d\n", player.getMp(), player.getMp() + 30);
			player.setHp(player.getHp() + player.getHp() / 2);
			player.setMp(player.getMp() + 30);
			player.setExp(0);
			player.levelUP();
		}
	}

	private void battleStart(Unit monster) {
		System.out.println("야생의 적을 만났다!");
		while (true) {
			System.out.printf("[플레이어][Lv.%d]\n> HP : %.1f | MP : %d\n[%s][Lv.%d]\n> HP : %.1f\n",player.getLevel(), player.getHp(), player.getMp(), name, monster.getLevel(),
					monster.getHp());
			System.out.println("======================");
			int sel = input("[1] 일반공격 [2] 스킬");
			if (sel == 1) {
				player.attack(monster);
				System.out.println();
				monster.attack(player);
				System.out.println();
			} else if (sel == 2) {
				sel = input("[1] 연속베기 (마나 -10) [2] 힐 (마나 -30)");
				if (sel == 1 || sel == 2)
					player.skill(sel, monster);
				System.out.println();
				monster.attack(player);
				System.out.println();
			}
			if (battleEnd(monster))
				break;
		}
	}

	private boolean battleEnd(Unit monster) {
		if (monster.getHp() <= 0) {
			System.out.println("적을 처치했다!");
			player.setExp(player.getExp() + 5);
			System.out.println("경험치 5 상승!");
			monsterRespawn(monster);
			return true;
		}
		if (player.getHp() <= 0) {
			System.out.println("플레이어는 죽었다-");
			return true;
		}
		return false;
	}
	
	private void monsterRespawn(Unit monster) {
		int enemyPos = monster.getPos() + ran.nextInt(2)+2;
		String temp[] = name.split(" ");
		String enemyType = temp[1];
		if(enemyType.equals("좀비")) {
			zombie = new Zombie(20 + zombie.getHp() + 2 * player.getLevel(), 0, ran.nextInt(player.getLevel())+1, 0, enemyPos);
		}else if(enemyType.equals("스켈레톤")) {
			skeleton = new Skeleton(10 + skeleton.getHp() + 2 * player.getLevel(), 0, ran.nextInt(player.getLevel())+1, 0, enemyPos);
		}
	}
	
	private void play() {
		if (player.getPos() == boss.getPos()) {
			name = boss.setName();
			battleStart(boss);
		} else if (player.getPos() == zombie.getPos()) {
			name = zombie.setName();
			battleStart(zombie);
		} else if (player.getPos() == skeleton.getPos()) {
			name = skeleton.setName();
			battleStart(skeleton);
		}
	}

	private boolean isRun(int select) {
		if (select == 1)
			return true;
		else if(select == 2)
			return false;
		else 
			return isRun((input("(재입력) [1] 이동 [2] 종료")));
	}

	private int input(String msg) {
		System.out.println(msg + "\n");
		String input = scan.nextLine();
		int sel = 0;
		try {
			sel = Integer.parseInt(input);
		} catch (Exception e) {
		}
		return sel;
	}

	public void run() {
		defaultEntity();
		while (stage > 0) {
			levelUp();
			if (isRun(input("[1] 이동 [2] 종료"))) {
				move();
				play();
			} else
				break;
			stage--;
		}
	}
}
