package lesson09.practicaltask01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtilShape {

	public String inputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inString = null;
		try {
			inString = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inString;
	}

	public int inputInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inInt = 0;
		try {
			inInt = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inInt;
	}
}
