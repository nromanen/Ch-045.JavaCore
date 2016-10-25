package forExam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Car extends Garage{
	private String colour;
	private Calendar productionDate;
	private String mark;
	private String description;
	
	public Car(String mark, int month, int year, String colour) throws ParseException
	{
		this.mark = mark;
		this.productionDate =  getCalendar( month,  year);
		this.colour = colour;
	}
	public Calendar getCalendar(int month, int year) {
	    Calendar date = Calendar.getInstance();
	    date.set(Calendar.YEAR, year);
	    date.set(Calendar.MONTH, month+1);
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
	

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDescription() {
		Owner owner = new Owner("Ivanov","Alex",03243435454, "Kopernika 11");			
		return description = "Car -"+getMark()+" year -"+getYear()+" owner - "+owner.toString();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Car mark - "+mark+", producted  "+getYear() +", colour - "+colour;
	}

}
