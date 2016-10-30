package lesson9homeworktask4;

import java.util.ArrayList;

public class MainUtils {
 public int listLength(ArrayList<String> list)
 {int i =0;
	 for(String s : list)
	 {
		 i++;
		 	 }
	return i;
 }
 
 public String longestString(ArrayList<String> list)
 
 { int max =0;int index =0;
	 for(int i=0;i<list.size();i++)
 {
 if(max<list.get(i).length())
	 max=list.get(i).length();
 index = i;
 }
	 return "The longest line is line number - "+index+" with "+max+" symbols.";
 }
}
