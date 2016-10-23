package les7StringRegularExpressions;

/*1. Enter in the console sentence of five words. 
display the longest word in the sentence
determine the number of its letters
bring the second word in reverse order
2.Enter a sentence that contains the words between more than one space. 
Convert all spaces, consecutive, one. For example, if we introduce the sentence "I    am      learning     Java   Coreª,
 we have to get the "I'm learning Java Coreª
3.Implement a pattern for US currency: the first symbol "$", then any number of digits, 
dot and two digits after the dot. Enter the text from the console that contains several occurrences of US currency. 
Display all occurrences on the screen.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException
	{
		
	/*	#1
	 * LongestWord lw = new LongestWord();
	lw.longestWord();
	SecondWordInReverseOrder sec = new SecondWordInReverseOrder();
	 sec.secondWordInReverseOrder1();
	 RemoveExtraSpaces rem = new RemoveExtraSpaces();
		*/
		// task #2 here
		//RemoveExtraSpaces rem = new RemoveExtraSpaces();
		//System.out.println(rem.removeSpace("     I    am      learning     Java   Core"));
		
		Find$andoutput find = new Find$andoutput();  //#3
		String s = "$0.22 $12.23 $12.222 ‚‡4.7‚‡; 4.55 sadsd $32434334";
		find.find$(s);
	
		
	
	}
}
