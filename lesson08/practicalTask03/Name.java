package lesson08.practicalTask03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name {

	private String name;

	public Name() {

	}

	public Name(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
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

	@Override
	public String toString() {
		return "Person's name is: " + name + ". It is valid: " + checkName(name);
	}

}
