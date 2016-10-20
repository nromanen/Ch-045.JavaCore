package regularexpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryWordForMatcher {
	public boolean TryWord(String text) {
		String pattern = "[A-Z]{1}[a-z]{2,14}(-[A-Z]{1}[a-z]{2,14})?";

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		return m.matches();
	}

	public boolean IfContains(String s1, String s2) {
		String pattern = s1;
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s2);
		return m.find();
	}

	public void EnterNameAndOutPutName() throws IOException {
		System.out.println("Input please name, patronomic and lastname: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		String patronomic = reader.readLine();
		String lastName = reader.readLine();
		char nameFirst = name.charAt(0);
		char patronomicFirst = patronomic.charAt(0);
		reader.close();
		System.out.println(lastName + " " + nameFirst + "." + patronomicFirst + ".");

	}

	public void EnterNameAndOutPutNamefromOneString() throws IOException {
		System.out.println("Input please name, patronomic and lastname in one string(use space): ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		reader.close();
		String[] arr = name.split("\\W+");
		String newName = arr[0];
		String newPAtronom = arr[1];
		String newLast = arr[2];
		char nameFirst = newName.charAt(0);
		char patronomicFirst = newPAtronom.charAt(0);

		System.out.println("Dear " + newName + " " + nameFirst + "." + patronomicFirst + ".");

	}
}
