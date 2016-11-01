package lesson10.practicaltask03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilText {

	public List<String> addToLine(File file) throws IOException {
		BufferedReader in = null;
		List<String> myList = new ArrayList<String>();
		try {
			in = new BufferedReader(new FileReader(file));
			String str;
			while ((str = in.readLine()) != null) {
				myList.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return myList;
	}

	public void printLine(List<String> list) {
		for (String in : list) {
			System.out.println(in);
		}
	}

	public void quantityOfSymbols(List<String> list) {
		for (String in : list) {
			int quantityOfChars = 0;
			quantityOfChars += in.length();
			System.out.println(in);
			System.out.println("The number of Symbols in carrent line is: " + quantityOfChars);
		}
	}

	public void totalNumber(File file) {
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int words = 0;
		int lines = 0;
		int chars = 0;

		while (in.hasNextLine()) {
			lines++;
			String line = in.nextLine();
			chars += line.length();
			words += new StringTokenizer(line, " ,").countTokens();
		}
		System.out.println(file.getName() + " consist of " + lines + " lines");
		System.out.println(file.getName() + " consist of " + words + " words");
		System.out.println(file.getName() + " consist of " + chars + " chars");
	}

	public String longestLine(List<String> list) {
		String longestLine = "";
		int length = list.get(0).length();
		for (String in : list) {
			if (in != null) {
				if (in.length() > length) {
					longestLine = in;
					length = in.length();
				}
			}
		}
		return longestLine;
	}

	public String shortestLine(List<String> list) {
		String shortestLine = "";
		int length = list.get(0).length();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				if (list.get(i).length() < length) {
					shortestLine = list.get(i);
				}
			}
		}
		return shortestLine;
	}

	public void containsValue(String value1, List<String> list) {

		for (int i = 0; i < list.size(); i++) {
			boolean temp = false;
			String value2 = list.get(i);
			if (value1 != null & value2 != null) {
				String pattern = value1;
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(value2);
				temp = m.find();
			}
			if (temp == true) {
				System.out.println(list.get(i));
			}

		}

	}
}
