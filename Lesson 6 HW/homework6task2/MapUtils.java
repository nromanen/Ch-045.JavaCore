package homework6task2;

import java.util.*;

public class MapUtils  {

	
	public static void checkTheSameNames(Map<String, String> map) {

		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		ArrayList<String> sameNames = new ArrayList<>();
		for (Map.Entry<String, String> list : map.entrySet()) {
			int count = 0;
			while (iterator.hasNext()) {
				Map.Entry<String, String> pair = iterator.next();
				String value = pair.getValue();
				if (value.equals(list.getValue())) {
					count++;
					if (count >= 2)
						sameNames.add(value);
				}
			}

		}

		System.out.println("The list of same names " + sameNames);

	}

	public static Map<String, String> removePersonByName(String s, Map<String, String> map) {
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> pair = iterator.next();
			if (pair.getValue().equals(s)) {
				iterator.remove();
			}
		}
		return map;
	}

}
