package lesson08.practicalTask02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonUtil {

	public PersonUtil() {

	}

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

	public boolean checkName(String name) {
		boolean temp = false;
		if (name != null) {
			String pattern = "[A-Z]{1}[a-z]{2,14}(-[A-Z]{1}[a-z]{2,14})?";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(name);
			temp = m.matches();
		}
		return temp;
	}

	public String outputSurname(String surname, String name, String middleName) {
		String temp;
		if (checkName(surname) == true & checkName(name) == true & checkName(middleName) == true) {
			temp = surname + " " + name.charAt(0) + "." + middleName.charAt(0);
		} else {
			temp = "You have entered wrong data";
		}
		return temp;
	}

	public String outputName(String name) {
		String temp;
		if (checkName(name) == true) {
			temp = name;
		} else {
			temp = "You have entered wrong data";
		}
		return temp;
	}

	public String outputPersonData(String surname, String name, String middleName) {
		String temp;
		if (checkName(surname) == true & checkName(name) == true & checkName(middleName) == true) {
			temp = name + " " + middleName + " " + surname;
		} else {
			temp = "You have entered wrong data";
		}
		return temp;
	}
}
