package les7StringRegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find$andoutput {
	public void find$(String text) {
		String pattern = "(\\${1}(\\d*)(\\.\\d{2})*)*";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.print(text.substring(m.start(), m.end())+" ");
		}		
	}

}