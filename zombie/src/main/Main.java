package main;

import java.util.Random;
import java.util.Scanner;
import Player.*;
import Monster.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		User player = new User(200, 100, 1, 0, 0);
		Zombie zombie = new Zombie(100, 0, 1, 0, 3);
		Skeleton skeleton = new Skeleton(50, 0, 1, 0, 7);
		Boss boss = new Boss(400, 0, 5, 0, 10);

		int pos = 0;
		while (true) {
			if (player.getexp() == 10) {
				player.setExp(0);
				player.levelUP();
			}
			int sel = scan.nextInt();
			if (sel == 1)
				pos++;
			player.setPos(pos);

			if (pos == 3) {
				System.out.println("야생의 좀비를 만났다!");
				while (true) {
					System.out.printf("[플레이어]\nHP : %.1f | MP : %d\n[좀비]\nHP : %.1f\n", player.getHp(), player.getMp(), zombie.getHp());
					System.out.println("======================");
					System.out.println("[1] 일반공격 [2] 스킬");
					sel = scan.nextInt();
					if(sel == 1) {
						zombie.attack(player);
						player.attack(zombie);
						System.out.println();
					}else if(sel == 2) {
						System.out.println("[1] 연속베기 [2] 힐");
						sel = scan.nextInt();
						if(sel == 1 || sel == 2) {
							player.skill(sel, zombie);
						}
						zombie.attack(player);
					}
						
					
					if (zombie.getHp() <= 0) {
						System.out.println("좀비를 처치했다!");
						player.setExp(player.getexp() + 1);
						System.out.println("경험치 1 상승!");
						break;
					}
					if (player.getHp() <= 0) {
						System.out.println("플레이어는 죽었다-");
						break;
					}
				}
			}

			if (pos == 7) {
				System.out.println("야생의 스켈레톤을 만났다!");
				while (true) {
					skeleton.attack(player);
					player.attack(skeleton);
					System.out.println();
					
					if (skeleton.getHp() <= 0) {
						System.out.println("스켈레톤을 처치했다!");
						player.setExp(player.getexp() + 1);
						System.out.println("경험치 1상승!");
						break;
					}
					if (player.getHp() <= 0) {
						System.out.println("플레이어는 죽었다-");
						break;
					}
				}
			}

			if (pos == 10) {
				System.out.println("야생의 보스를 만났다!");
				while (true) {
					boss.attack(player);
					player.attack(boss);
					System.out.println();
					
					if (boss.getHp() <= 0) {
						System.out.println("보스를 처치했다!");
						player.setExp(player.getexp() + 1);
						System.out.println("경험치 1 상승!");
						break;
					}
					if (player.getHp() <= 0) {
						System.out.println("플레이어는 죽었다-");
						break;
					}
				}
			}
			if (player.getHp() <= 0)
				break;
		}
	}
}
