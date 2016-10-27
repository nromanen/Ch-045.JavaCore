package lesson9practicaltask3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
 public static void main(String[] args) throws IOException
 {
	 BufferedReader reader=null;
		try {
			 reader = new BufferedReader(new FileReader("d:/1.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Wrong directory");
		}
		ArrayList<String> list = new ArrayList<>();
		
		String s = reader.readLine();
		while(s!=null)
		{
			list.add(s);
			s = reader.readLine();
			
				
			}
		
		int i=0;
		for(String g : list){
		System.out.println(i+++" line has length "+g.length());
		}
		int b=0;
		
		for(String k : list){
			k =MainUtils.removeSpace(k);
			System.out.println(k);}
		MainUtils.theLongestLine(list);
		MainUtils.theShortestLine(list);
		MainUtils. searchVar("var",  list);
	}
	
 }

