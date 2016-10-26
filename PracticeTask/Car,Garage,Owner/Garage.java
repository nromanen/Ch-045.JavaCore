package forExam;



import java.util.ArrayList;


public class Garage {
	ArrayList<Car> list = new ArrayList<>();
	Owner owner = new Owner("Ivanov", "Alex", 03243435454, "Kopernika 11");

	public ArrayList<Car> garageAddCar(Car car) {
		 list.add(car);
		 return list;
	}
	public ArrayList<Car> getlist() {
		return list;
	}
}
