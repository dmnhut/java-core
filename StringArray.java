package __;

public class StringArray {
	public static void result(int[] __, int el) {
		for (int i = 0; i < __.length; i++) {
			if (__[i] == el) {
				System.out.println("[" + i + "]" + " = " + el);
				return;
			}
		}
		System.out.println("[undefined] = " + el);
	}
}
