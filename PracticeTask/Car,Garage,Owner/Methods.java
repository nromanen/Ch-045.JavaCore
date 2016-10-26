package forExam;

import java.util.ArrayList;

import java.util.Comparator;

public class Methods {
	Garage gar = new Garage();
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
	
}
