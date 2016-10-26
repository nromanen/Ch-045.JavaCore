package lesson8homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		Methods met = new Methods();
		System.out.println("Input please two double numbers:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double a = 0;

		try {
			a = Double.parseDouble(reader.readLine());
		} catch (NumberFormatException | IOException e1) {
			System.out.println(e1.getStackTrace());
		}

		double b = 0;

		try {
			b = Double.parseDouble(reader.readLine());
		} catch (NumberFormatException | IOException e1) {
			System.out.println("uu");
		}

		try {
			System.out.println(met.div(a, b));
		} catch (ArithmeticException e) {
			System.out.println("oops");
		}
		
		try {
			System.out.println("You are in with "+met.readNumber(1, 10));
		} catch (Exception e) {
			
			System.out.println("oops, out of range");;
		}
	}
}
