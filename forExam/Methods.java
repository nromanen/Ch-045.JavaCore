package forExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Comparator;

public class Methods {

	Garage gar = new Garage();
	ArrayList<Car> list2 = gar.getlist();
	public static Comparator<Car> compareByYear = new Comparator<Car>() {
		@Override
		public int compare(Car car1, Car car2) {

			return car1.getYear() - car2.getYear();
		}
	};

	public static Comparator<Car> compareByModel = new Comparator<Car>() {
		@Override
		public int compare(Car o1, Car o2) {
			return o1.getModel().compareTo(o2.getModel());
		}
	};

	public void getCarByModel(String model) {

		for (Car car : gar.getlist()) {
			if (model.equals(car.getModel()))
				System.out.println("Sir, " + car.getModel() + " engine is launched");

		}
	}

	public String inputModelNameAndGetDiscription(String model) {
		String s = "Sir, we dont have model - " + model;
		for (Car car : gar.getlist()) {
			if (model.equals(car.getModel())) {
				s = car.getDescription();
			}
		}
		return s;
	}

	public void carsToFile(ArrayList<Car> list) throws IOException {
		File file = new File("d:/practice.txt");
		OutputStream stream;
		try {
			stream = new FileOutputStream(file);
			for (Car car : list) {

				stream.write(car.toString().getBytes());
				stream.write(System.getProperty("line.separator").getBytes());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
