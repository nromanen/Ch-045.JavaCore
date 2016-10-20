package regularexpressions;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException
	{
		TryWordForMatcher tr = new TryWordForMatcher();
		System.out.println(tr.TryWord("Maksym-ggA"));
		System.out.println(tr.IfContains("mother", "I love my mother"));
		tr.EnterNameAndOutPutName();
		tr.EnterNameAndOutPutNamefromOneString();
		
	}
}
