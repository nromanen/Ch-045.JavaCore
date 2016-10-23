package lesson08.homework03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsdUtil {

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

	public void printUsd(String line) {
		if (line != null) {
			String pattern = "\\$(\\d*)(\\.\\d{2})?";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(line);
			while (m.find()) {
				System.out.print(line.substring(m.start(), m.end()) + "\n");
			}
		}
	}
}
