package lesson10.practicaltask03;
/* Prepare mytext.txt file with a lot of text inside.
Read context from file into array of strings.
Each array item contains one line from file.
Complete next tasks:
   1) count and write the number of symbols in every line.
   2) find the longest and the shortest line. 
   3) find and write only that lines, which consist of word «var»
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppText {
	public static void main(String[] args) throws IOException {
		// read file
		UtilText util = new UtilText();
		File file = new File("text.txt");
		List<String> myList = new ArrayList<>();
		myList = util.addToLine(file);
		
		// count and write the number of symbols in every line
		util.quantityOfSymbols(myList);
		util.totalNumber(file);
		System.out.println();
		
		//shortest and longest line
		System.out.println("The longest line is: ");
		System.out.println(util.longestLine(myList));
		System.out.println("The shortest line is: ");
		System.out.println(util.shortestLine(myList));
		System.out.println();
		
		//find and write only that lines, which consist of word «state»
		System.out.println("Lines, which consist of word: state.");
		util.containsValue("state", myList);

	}
}
