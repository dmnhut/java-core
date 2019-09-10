package __;

import java.util.Scanner;

public class PTB1 {
	private static Scanner input;
	private static float a;
	private static float b;

	public static void main(String[] __) {
		nhap();
		giaiPhuongTrinh();
	}

	public static void nhap() {
		input = new Scanner(System.in);
		a = input.nextFloat();
		b = input.nextFloat();
	}

	public static void giaiPhuongTrinh() {
		if (a == 0) {
			if (b == 0) {
				System.out.println("phuong trinh vo so nghiem");
			} else {
				System.out.println("phuong trinh vo nghiem");
			}
		} else {
			System.out.println("x = " + (float) -b / a);
		}
	}
}
