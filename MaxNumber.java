package __;

import java.util.Scanner;

public class MaxNumber {
	private static Scanner input;

	public static void main(String[] __) {
		input = new Scanner(System.in);
		float $1 = input.nextFloat();
		float $2 = input.nextFloat();
		if ($1 == $2) {
			System.out.println("hai so bang nhau");
		} else {
			if ($1 > $2) {
				System.out.println("so lon la: " + $1);
			} else {
				System.out.println("so lon la: " + $2);
			}
		}
	}
}
