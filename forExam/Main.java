package forExam;

/*
 * Create class Car with fields: mark, productionDate, color, description.
Create class Owner with fields: lastName, firstName, Address
Create class Garage with fields: owner, cars.
Consider appropriate methods.
 */

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException, IOException, SQLException {
		Methods method = new Methods();
		ForWorkWithDB fordb = new ForWorkWithDB();
		Garage gar = new Garage();

		Car car1 = new Car("Ford", 12, 1980, "grey");
		Car car2 = new Car("Mercedes", 01, 2003, "black");
		Car car3 = new Car("Fiat", 04, 2000, "white");
		Car car4 = new Car("Buggatti", 12, 1940, "red");

		gar.garageAddCar(car1);
		gar.garageAddCar(car2);
		gar.garageAddCar(car3);
		gar.garageAddCar(car4);

		fordb.outputTable();
		method.carsToFile(gar.getlist());
	}
}
