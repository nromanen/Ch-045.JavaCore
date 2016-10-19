package lesson6practicaltask2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practiceMap {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Map<Integer, String> employeeMap = new HashMap<>();
		employeeMap.put(1, "Zavadskii Ivan");
		employeeMap.put(2, "Zigota");
		employeeMap.put(3, "Zoyan");
		employeeMap.put(4, "Zaya");
		employeeMap.put(5, "Zina");
		employeeMap.put(6, "Alex");
		employeeMap.put(7, "Peppa");
		System.out.println(employeeMap);

		MapUtils.findPersonsNameByID(employeeMap);
		MapUtils.findIDByName(employeeMap);
	}

}
