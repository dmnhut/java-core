package __;

import java.util.Scanner;

public class NumberCheck {
	private static Scanner input;

	public static void main(String[] __) {
		input = new Scanner(System.in);
		int num = input.nextInt();
		isPositve(num);
		isOdd(num);
	}

	public static void isPositve(int $) {
		if ($ > 0) {
			System.out.println("so duong");
		} else {
			if ($ == 0) {
				System.out.println("so 0");
			} else {
				System.out.println("so am");
			}
		}
	}

	public static void isOdd(int $) {
		if ($ % 2 == 0) {
			System.out.println("so chan");
		} else {
			System.out.println("so le");
		}
	}
}
