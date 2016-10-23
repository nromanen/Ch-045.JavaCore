package les7StringRegularExpressions;


import java.io.*;

public class LongestWord extends Main{
	
	public void longestWord() throws IOException
	{int max = 0;
	int index = 0;
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Input please five words in one string");
	String string = reader.readLine();
	reader.close();
	
	String[] arr = string.split("\\W+");
	
	for(int j=1;j<arr.length;j++)
	{
				
			if(	arr[j].length()>max)
			{
				max=arr[j].length();
				index = j;
			}
		}
	 
	System.out.println("The longest word is "+arr[index]+" with "+max+" letters.");
	}
}
