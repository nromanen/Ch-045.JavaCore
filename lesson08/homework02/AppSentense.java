package lesson08.homework02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Enter a sentence that contains the words between more than one space. 
 * Convert all spaces, consecutive, one. For example, if we introduce the sentence 
 * "I    am      learning     Java   Core», we have to get the "I'm learning Java Core»
 */

public class AppSentense {

	public static void main(String[] args) {
		// first way
		String line = "I    am      learning     Java   Core";
		String newLine = line.replaceAll("\\s+", " ");
		System.out.println(newLine);

		// second way
		Pattern pattern = Pattern.compile("\\s+");
		Matcher matcher = pattern.matcher(line);
		String str = matcher.replaceAll(" ");
		System.out.println(str);

	}
}
