package lesson09.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {

	public double div(double a, double b) {
		if(b==0){ throw new ArithmeticException("Division by zero");}
		return a/b;
	}

	public int inputInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inInt = 0;
		try {
			inInt = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inInt;
	}

	public int readNumber(int start, int end) throws Exception {
		int temp = inputInt();
		int temp2 = 0;
		if (temp <= start | temp >= end) {
			throw new Exception("Given number is not included in the range ("+start+":"+end+")");
		} else {
			temp2 = temp;
		}
		return temp2;
	}

}
