package forExam;

import java.text.ParseException;

import java.util.*;

public class Car {
	private String colour;
	private Calendar productionDate;
	private String model;

	public Car(String mark, int month, int year, String colour) throws ParseException {
		this.model = mark;
		this.productionDate = getCalendar(month, year);
		this.colour = colour;
	}

	public Calendar getCalendar(int month, int year) {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, year);
		date.set(Calendar.MONTH, month + 1);
		return date;
	}

	public Calendar getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Calendar productionDate) {
		this.productionDate = productionDate;
	}

	public int getYear() {
		return ((Calendar) productionDate).get(Calendar.YEAR);
	}

	public int getMonth() {
		return ((Calendar) productionDate).get(Calendar.MONTH);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDescription() {
		
		return "Car -" + getModel() + " year -" + getYear()+" colour -"+getColour();
	}

	@Override
	public String toString() {
		return "Car mark - " + model + ", producted  " + getYear() + ", colour - " + colour;
	}

}
