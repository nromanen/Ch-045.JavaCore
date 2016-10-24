package regularexpressions;
/*
 *1. Enter in the console sentence of five words. 
display the longest word in the sentence
determine the number of its letters
bring the second word in reverse order
2.
Enter a sentence that contains the words between more than one space. Convert all spaces,
 consecutive, one. For example, if we introduce the sentence "I    am      learning     Java   Core», 
 we have to get the "I'm learning Java Core»
3.Implement a pattern for US currency: the first symbol "$", then any number of digits, dot and two digits after the dot. 
Enter the text from the console that contains several occurrences of US currency. Display all occurrences on the screen.

 */



import java.io.IOException;

import les7StringRegularExpressions.RemoveExtraSpaces;

public class Main {
	public static void main(String[] args) throws IOException
	{
		
		TryWordForMatcher tr = new TryWordForMatcher();
		System.out.println(tr.isMatches("Maksym-ggA","[A-Z]{1}[a-z]{2,14}(-[A-Z]{1}[a-z]{2,14})?"));
		System.out.println(tr.ifContains("mother", "I love my mother"));
	//	tr.enterNameAndOutPutName();
		tr.enterNameAndOutPutNamefromOneString(); 
		
		
	}
}
