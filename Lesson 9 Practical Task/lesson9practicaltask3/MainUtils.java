package lesson9practicaltask3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainUtils {
	
	public static String removeSpace(String inComeString)
	{ 
			return 		inComeString.replaceAll("\\s+", "");
	}
	
	public static void theLongestLine(ArrayList<String> list)
	{int index=0;
		int max=list.get(0).length();
		for(int i=0;i<list.size();i++){
		if(max<list.get(i).length()){
			max=list.get(i).length();
	 index = i;}
				}
		System.out.println("the longest line is - "+index+" with "+max+" simbols");
	}
	
	public static void searchVar(String var, ArrayList<String> list)
	{int i=0;
		for(String s : list)
		{i++;
			if(s.toLowerCase().contains(var)){
				System.out.println("line "+i+" contains var ");
			}
		}
		
		
	}
	public static void theShortestLine(ArrayList<String> list)
	{int index=0;
		int min=list.get(0).length();
		for(int i=0;i<list.size();i++){
		if(min>list.get(i).length()){
			min=list.get(i).length();
	 index = i;}
				}
		System.out.println("the shortest line is - "+index+" with "+min+" simbols");
	}
	
}

