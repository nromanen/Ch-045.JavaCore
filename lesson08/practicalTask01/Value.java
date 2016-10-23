package lesson08.practicalTask01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Value {

	public boolean containsValue(String value1, String value2) {
		boolean temp = false;
		if (value1 != null & value2 != null) {
			String pattern = value1;
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(value2);
			temp = m.find();
		}
		return temp;
	}
}
