package oddnumber;

import java.io.*;

public class OddNumber {
	public static void main(String args[]) throws Exception {
		System.out.println("Введите 3 числа");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(reader.readLine());
		int n2 = Integer.parseInt(reader.readLine());
		int n3 = Integer.parseInt(reader.readLine());
		Odd(n1);
		Odd(n2);
		Odd(n3);

	}

	public static int Odd(int m) {
		if ((m % 2) == 0) {
			System.out.println("Число " + m + " четное ");
			return m;
		} else
			System.out.println("Число нечетное.");
		return m;
	}

}
