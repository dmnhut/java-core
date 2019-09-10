package __;

import java.util.Scanner;

public class CoffeeMenu {
	private static Scanner input;
	private static int LENGTH = 3;
	private static String[] coffees = { "cafe", "tra da", "cafe sua" };
	private static double[] gias = { 10000, 10000, 15000 };
	private static int loaiCoffees;
	private static int soLuong;

	public static void main(String[] __) {
		inMenu();
		chonCoffee();
		System.out.println();
		hoaDon();
	}

	public static void inMenu() {
		for (int i = 0; i < LENGTH; i++) {
			System.out.println((i + 1) + ". " + coffees[i] + ": " + gias[i]);
		}
	}

	public static void chonCoffee() {
		input = new Scanner(System.in);
		loaiCoffees = input.nextInt();
		soLuong = input.nextInt();
	}

	public static void hoaDon() {
		for (int i = 0; i < LENGTH; i++) {
			if (i + 1 == loaiCoffees) {
				System.out.println("tien thanh toan cua " + coffees[i] + ": " + gias[i] * soLuong);
				return;
			}
		}
	}
}
