package forExam;

/*
 * Create class Car with fields: mark, productionDate, color, description.
Create class Owner with fields: lastName, firstName, Address
Create class Garage with fields: owner, cars.
Consider appropriate methods.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Garage extends Owner {
	public static void main(String[] args) throws ParseException {
		ArrayList<Car> list = new ArrayList<>();
		Owner owner = new Owner("Ivanov", "Alex", 03243435454, "Kopernika 11");

		Car car1 = new Car("Ford", 12, 1980, "grey");
		list.add(car1);
		Car car2 = new Car("Mercedes", 01, 2003, "black");
		list.add(car2);
		Car car3 = new Car("Fiat", 04, 2000, "white");
		list.add(car3);
		Car car4 = new Car("Buggatti", 12, 1940, "red");
		list.add(car4);
		Collections.sort(list, compareByYear);
		System.out.println(list);
		Collections.sort(list, compareByModel);
		System.out.println(list);
		inputModelAndEngineWillLaunch("Buggatti", list); // when owner comes to	 garage he only names a car and engine starts
		inputModelNameAndGetDiscription(list); // when you want to know info about a car by model
		System.out.println(whatCarshouldIDriveToday(list)); //when you dont know what car to take today)
	}

	public static Comparator<Car> compareByYear = new Comparator<Car>() {
		@Override
		public int compare(Car car1, Car car2) {
			if (car1.getYear() < car2.getYear())
				return -1;
			else if (car1.getYear() > car2.getYear())

				return 1;
			else
				return 0;
		}
	};
	public static Comparator<Car> compareByModel = new Comparator<Car>() {
		@Override
		public int compare(Car o1, Car o2) {
			return o1.getMark().compareTo(o2.getMark());
		}
	};

	public static void inputModelAndEngineWillLaunch(String mark, ArrayList<Car> list) {
		for (Car car : list) {
			if (mark.equals(car.getMark()))
				System.out.println("Sir, " + car.getMark() + " engine is launched");
		}
	}

	public static void inputModelNameAndGetDiscription(ArrayList<Car> list) {
		String model = null;
		System.out.println("Input please model name:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			model = reader.readLine();
		} catch (IOException e) {
			System.out.println("Incorrect model name");
		}
		for (Car car : list) {
			if (model.equals(car.getMark()))
				System.out.println(car.getDescription());
		}
	}
	
	public static  String whatCarshouldIDriveToday(ArrayList<Car> list)
	{Calendar date = Calendar.getInstance();
		int day = date.DAY_OF_WEEK;
		while(day>list.size())
		{
			day-=list.size();
		}
		return "Today is "+day+" day of the week, time to drive - "+list.get(day).getMark();
	}

}
