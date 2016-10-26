package lesson8homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Methods {
	public double div(double a, double b) {
		if (b == 0) {
			throw new ArithmeticException();
		}
		return a / b;
	}

	public int inputNumber() {

		int number = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input please int");

		try {
			number = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {

			System.out.println(" NumberFormatException");
		} catch (IOException e) {
			System.out.println(" IOException");
		}

		return number;
	}

	public int readNumber(int start, int end) throws Exception {
		int result = inputNumber();
		if (result < start || result > end) {
			throw new Exception("Out of range");
		} else
			return result;
	}
}
