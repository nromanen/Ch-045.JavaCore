package lesson08.homework01;

/* Enter in the console sentence of five words. 
1) display the longest word in the sentence
2) determine the number of its letters
3) bring the second word in reverse order 
 */

public class AppStringUtil {

	public static void main(String[] args) {
		StringUtil util = new StringUtil();

		System.out.println("Enter a line: ");
		String line = util.inputString();

		String longestWord = util.LongestWord(line);
		System.out.println("The longest word in the line is: " + longestWord);
		System.out.println("Length of the longest word is " + longestWord.length() + " symbols");

		String secondWorld = util.getNthWord(line, 2);
		System.out.println("Second world of the line is: " + secondWorld);
		System.out.println("Second world in the reverse order: " + util.reverseWorld(secondWorld));

	}

}
