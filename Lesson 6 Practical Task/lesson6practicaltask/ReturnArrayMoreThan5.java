package lesson6practicaltask;

import java.util.ArrayList;

public class ReturnArrayMoreThan5 {
	public static ArrayList<Integer> returnIndexNumbersBiggerThan5(int a, ArrayList<Integer> list) {
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			//if (i == 0 && list.get(i) > a) {
			//	newArray.add(i);
			//i++;
		//	}

			 if (list.get(i) > a) {
				// System.out.println(list);
				list.remove(i);
				// i++;
				newArray.add(i);
			}
			
		}
		return newArray;
	}

}
