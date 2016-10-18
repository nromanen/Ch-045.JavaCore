package lesson6practicaltask;

import java.util.*;

public class CollectionsPractice {
	public static void main(String[] args) {
		ArrayList<Integer> myCollection = new ArrayList<>();
		ArrayList<Integer> newCollection = new ArrayList<>();
		ArrayList<Integer> CollectionForInsert = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			myCollection.add((int) (Math.random() * 100));
		}
		for (int i = 0; i < myCollection.size(); i++) {
			if (myCollection.get(i) > 5) {
				newCollection.add(myCollection.get(i));
			}
		}

		System.out.println("List newCollection: " + newCollection);

		for (int i = 0; i < myCollection.size(); i++) {
			if (myCollection.get(i) > 20) {
				myCollection.remove(myCollection.get(i));
				i--;
			}
		}

		System.out.println("List myCollection: " + myCollection);
		
		for (int i = 0; i < 10; i++) {
			CollectionForInsert.add((int) (Math.random() * 100));
		}
		CollectionForInsert.add(1, 1);
		CollectionForInsert.add(7, -3);
		CollectionForInsert.add(4, -4);
		
		for(int i=0;i<CollectionForInsert.size();i++)
		{
			System.out.println("CollectionForInsert  position - " + i + ", value of element -" + CollectionForInsert.get(i));
		}
		
		Collections.sort(CollectionForInsert);		
		System.out.println(ReturnArrayMoreThan5.returnIndexNumbersBiggerThan5(70, newCollection));
	}
		

}
