package lesson08.homework01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringUtil {

	public String inputString() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inString = null;
		try {
			inString = br.readLine();
		} catch (Exception e) {
			System.out.println("Not valid data. Please, input string data.");
		}
		return inString;
	}

	public String LongestWord(String line) {
		String temp = "You have written wrong data";
		if (line != null) {
			int length = 0;
			String words[] = line.split(" ");
			for (String in : words) {
				if (in.length() > length) {
					temp = in;
					length = in.length();
				}
			}
		}
		return temp;
	}

	public String getNthWord(String line, int nth) {
		String temp = null;
		if (line != null) {
			String[] arr = line.split(" ");
			if (nth - 1 < arr.length)
				temp = arr[nth - 1];
		}
		return temp;
	}

	public String reverseWorld(String word) {
		String temp = null;
		if (word != null) {
			StringBuilder sb = new StringBuilder(word);
			return sb.reverse().toString();
		}
		return temp;

	}

}
