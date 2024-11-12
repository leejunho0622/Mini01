package main;

import java.util.Scanner;

// Release v1.0.0

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("스테이지 수 입력");
		Stage stage = new Stage(scan.nextInt());
		stage.run();
	}
}
