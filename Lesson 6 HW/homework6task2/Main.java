package homework6task2;

import java.util.*;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

		Map<String, String> personMap = new HashMap<>();
		personMap.put("Vasiliv", "Vasya");
		personMap.put("Vasilivich", "Ivan");
		personMap.put("Ivanov", "Vasil");
		personMap.put("Ivanova", "Ivan");
		personMap.put("Rakov", "Vasil");
		personMap.put("Rakova", "Vasilisa");
		personMap.put("Karlov", "Vasya");
		personMap.put("Krakov", "Vasil");
		personMap.put("Kupich", "Val");
		personMap.put("Va", "Vil");

		System.out.println(personMap);

		MapUtils.checkTheSameNames(personMap);
		System.out.println(MapUtils.removePersonByName("Ivan", personMap));
	}
}