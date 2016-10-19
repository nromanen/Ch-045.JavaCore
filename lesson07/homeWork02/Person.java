package lesson07.homeWork02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Person {

	public Person() {
	}

	public void setTreeMap(TreeMap<String, String> map) {
		map.put("O'Konnor", "Ann");
		map.put("Timberlate", "Ben");
		map.put("Park", "Kate");
		map.put("White", "Sam");
		map.put("Golden", "Alice");
		map.put("Koen", "Peter");
		map.put("Larson", "Ann");
		map.put("Shiff", "Alex");
		map.put("Bertran", "Mark");
		map.put("Black", "Bruse");
	}

	public boolean getSameValue(TreeMap<String, String> map) {
		boolean status = false;
		Set<String> valueset = new HashSet<String>(map.values());
		if (map.values().size() != valueset.size()) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public void removeValue(TreeMap<String, String> map, String value) {
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			String val = map.get(key);
			if (val == value) {
				it.remove();
			}
		}

	}

	public void printMap(TreeMap<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Second name, first name: " + key + ", " + value);
		}

	}

}
