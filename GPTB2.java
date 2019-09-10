package __;

import java.util.Scanner;

public class GPTB2 {
	private static Scanner input;
	private static float a;
	private static float b;
	private static float c;
	private static double delta;

	public static void main(String[] __) {
		nhap();
		ketQua();
	}

	public static void nhap() {
		input = new Scanner(System.in);
		a = input.nextFloat();
		b = input.nextFloat();
		c = input.nextFloat();
		delta = Math.pow(b, 2) - 4 * a * c;
	}

	public static void ketQua() {
		if (delta < 0) {
			System.out.println("phuong trinh vo nghiem");
		} else {
			if (delta == 0) {
				System.out.println("x = " + -b / 2 * a);
			} else {
				System.out.println("x1 = " + (-b - Math.sqrt(delta)) / (2 * a));
				System.out.println("x2 = " + (-b + Math.sqrt(delta)) / (2 * a));
			}
		}
	}
}
