package __;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

public class FileInOutTest {
	private static final String FILENAME = "C:\\mydata\\database.db";
	private static Scanner scan;
	private static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String args[]) {
		scan = new Scanner(System.in);
		addCustomer();
		listCustomer();
		getCustomerByCode(scan.nextLine());
		deleteCustomerByCode(scan.nextLine());
		increaseTurnover(scan.nextLine(), scan.nextLong());
	}

	public static void testWriteToFile() {
		String s = "";
		InputStream is = System.in;
		while (true) {
			try {
				int ch = is.read();
				if (ch == '~')
					break;
				s += (char) ch;
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}
		try {
			byte b[] = s.getBytes();
			FileOutputStream file;
			file = new FileOutputStream(FILENAME, true);
			file.write(b);
			file.flush();
			file.close();
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	public static void testReadFromFile() {
		try {
			String s = "";
			BufferedReader buffered = new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME)));
			while (true) {
				s = buffered.readLine();
				if (s != null) {
					System.out.println(s);
				} else {
					break;
				}
			}
			buffered.close();
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	public static void addCustomer() {
		while (true) {
			scan = new Scanner(System.in);
			Customer.maKhachHang = scan.nextLine();
			Customer.hoTen = scan.nextLine();
			Customer.diaChi = scan.nextLine();
			Customer.doanhSo = scan.nextLong();
			try {
				DataOutputStream data = new DataOutputStream(new FileOutputStream(FILENAME, true));
				data.writeBytes(Customer.maKhachHang + " " + Customer.hoTen + " " + Customer.diaChi + " "
						+ Customer.doanhSo + "\n");
				data.flush();
				data.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
			System.out.print("contineu press 'y' or else to exit... ");
			if (!scan.next().equals("y")) {
				break;
			}
		}
	}

	public static void listCustomer() {
		try {
			DataInputStream data = new DataInputStream(new FileInputStream(FILENAME));
			while (data.available() > 0) {
				System.out.println(data.readLine());
			}
			data.close();
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	public static void getCustomerByCode(String makh) {
		try {
			DataInputStream data = new DataInputStream(new FileInputStream(FILENAME));
			while (data.available() > 0) {
				String s = data.readLine();
				map.put(s.split(" ")[0], s);
			}
			data.close();
			System.out.println(map.get(makh));
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	public static void deleteCustomerByCode(String makh) {
		String newData = "";
		String s = "";
		try {
			DataInputStream data = new DataInputStream(new FileInputStream(FILENAME));
			while (data.available() > 0) {
				s = data.readLine();
				if (!s.split(" ")[0].equals(makh)) {
					newData += s + "\n";
				}
			}
			data.close();
			try {
				DataOutputStream rewrite = new DataOutputStream(new FileOutputStream(FILENAME));
				rewrite.writeBytes(newData);
				rewrite.flush();
				rewrite.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

	public static void increaseTurnover(String makh, long sum) {
		String newData = "";
		String s = "";
		try {
			DataInputStream data = new DataInputStream(new FileInputStream(FILENAME));
			while (data.available() > 0) {
				s = data.readLine();
				if (s.split(" ")[0].equals(makh)) {
					sum += Long.parseLong(s.split(" ")[3]);
					newData += s.split(" ")[0] + " " + s.split(" ")[1] + " " + s.split(" ")[2] + " " + sum + "\n";
				} else {
					newData += s + "\n";
				}
			}
			data.close();
			try {
				DataOutputStream rewrite = new DataOutputStream(new FileOutputStream(FILENAME));
				rewrite.writeBytes(newData);
				rewrite.flush();
				rewrite.close();
			} catch (IOException ie) {
				System.out.println(ie);
			}
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}
}
