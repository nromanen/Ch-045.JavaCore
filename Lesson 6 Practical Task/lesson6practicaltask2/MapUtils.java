package lesson6practicaltask2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class MapUtils {
	public static void findPersonsNameByID(Map<Integer, String> map) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("Input please number of a person(ID): ");
			int a = Integer.parseInt(reader.readLine());
			if (map.containsKey(a)) {
				String name = map.get(a);
				System.out.println("Person with ID - " + a + " is " + name);
				break;
			} else
				System.out.println("Person with inputed ID is not exist((( try again");
		}

	}
	
	public static void findIDByName(Map<Integer, String> map) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Input please person's name : ");
			String name = reader.readLine();
			
				
			if (map.containsValue(name)) {
				for (Integer i : map.keySet()) {
					if (map.get(i).equals(name)) {
				System.out.println("Person " +name+ " has ID " + i.toString());
				
			}
					}
				break;	}
			else 
				System.out.println("Cannot find this person((( try again");
		}
	}
}
