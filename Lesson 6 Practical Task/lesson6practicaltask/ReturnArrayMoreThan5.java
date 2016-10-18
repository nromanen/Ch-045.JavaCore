package lesson6practicaltask;

import java.util.ArrayList;

public class ReturnArrayMoreThan5 {
	public static ArrayList<Integer> returnIndexNumbersBiggerThan5(int a, ArrayList<Integer> list) {
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
		
			 if (list.get(i) > a) {
				
				list.remove(i);
				
				newArray.add(i);
			}
			
		}
		return newArray;
	}

}
