package les7StringRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondWordInReverseOrder {
 
	public void secondWordInReverseOrder1() throws IOException
	{BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Input please five words in one string");
	String string = reader.readLine();
	reader.close();
	String[] arr = string.split("\\W+");
	String second = arr[1];
	 int len = second.length();
	   Character[] array = new Character[len];
	   for (int i = 0; i<len ;i++) {
	      array[i] = new Character(second.charAt(i));
	   }
	   for(int i=len-1;i>=0;i--)
	   {
		   System.out.print(array[i]);
	   }
	}
	
}
