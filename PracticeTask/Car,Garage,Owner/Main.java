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
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws ParseException
	{Methods method = new Methods();
	Garage gar = new Garage();
		
		
	Car car1 = new Car("Ford", 12, 1980, "grey");
	Car car2 = new Car("Mercedes", 01, 2003, "black");
	Car car3 = new Car("Fiat", 04, 2000, "white");
	Car car4 = new Car("Buggatti", 12, 1940, "red");
	
	gar.garageAddCar(car1);
	gar.garageAddCar(car2);
	gar.garageAddCar(car3);
	gar.garageAddCar(car4);
		
		
	Collections.sort(gar.getlist(), Methods.compareByYear);
	System.out.println(gar.list);
	Collections.sort(gar.list, Methods.compareByModel);
	System.out.println(gar.list);
	method.getCarByModel("Buggatti"); // when owner comes to	 garage he only names a car and engine starts
	
	String model=null;
	System.out.println("Input please model name:");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	try {
		 model = reader.readLine();
	} catch (IOException e) {
		System.out.println("Incorrect model name");
	}
	
	System.out.println(method.inputModelNameAndGetDiscription(model)); // when you want to know info about a car by model
	
}
}
