
public class Country {double summ;
	double tariff;
	int duration;
	
	public void makeCall(){
		InputOperations input = new InputOperations();
		
		while (true){
		input.message = "Enter tariff";
		tariff = input.inputDouble();
		
		input.message = "Enter duration";
		duration = input.inputInt();
		
		double call—ost = tariff * duration;
		
		summ = summ + call—ost;
		
		System.out.println("Cost of call is: " +  call—ost);
		
		System.out.println("Totaly cost is: " +  summ);
	}
		}

}
