package homework2ndtask;

/*Create an interface to the method calculatePay(), the base class Employee with a string variable employeeld.
Create two classes SalariedEmployee and ContractEmployee, which implement interface and are inherited from the base class.
Describe hourly paid workers in the relevant classes (one of the children), and fixed paid workers (second child).
Describe the string variable socialSecurityNumber in the class SalariedEmployee .
Include a description of federalTaxIdmember in the class of contractEmployee .
The calculation formula for the "time-worker“ is: "the average monthly salary = hourly rate * number of hours worked"
For employees with a fixed payment the formula is: "the average monthly salary = fixed monthly payment“
Create an array of employees and add the employees with different form of payment.
Arrange the entire sequence of workers descending the average monthly wage.
Output the employee ID, name, and the average monthly wage for all elements of the list.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<SalariedEmployee> listSalary = new ArrayList<>();
		ArrayList<ContractEmployee> listContract = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println(
					"To add an emloyee input 1 (for salaried) or 2 (for contract) or press enter to check their's salary");
			String i = reader.readLine();

			if (Integer.parseInt(i) == 1) {
				System.out.println("Input name of employee:");
				String name = reader.readLine();
				System.out.println(
						"Input employee's experience level: 1 - for beginner; 2 - for advanced; 3 - for profi:");
				int a = Integer.parseInt(reader.readLine());
				switch (a) {
				case 1:
					listSalary.add(new SalariedEmployee(name, Rate.BEGINNER.getSkillsRate()));
					break;
				case 2:
					listSalary.add(new SalariedEmployee(name, Rate.ADVANCED.getSkillsRate()));
					break;
				case 3:
					listSalary.add(new SalariedEmployee(name, Rate.PROFI.getSkillsRate()));
					break;
				}

			}
			if (Integer.parseInt(i) == 2) {
				System.out.println("Input name of employee:");
				String name = reader.readLine();
				System.out.println(
						"Input employee's experience level: 1 - for beginner; 2 - for advanced; 3 - for profi:");
				int a = Integer.parseInt(reader.readLine());
				switch (a) {
				case 1:
					listContract.add(new ContractEmployee(name, Rate.CONTRACT_BEGINNER.getSkillsRate()));
					break;
				case 2:
					listContract.add(new ContractEmployee(name, Rate.CONTRACT_ADVANCED.getSkillsRate()));
					break;
				case 3:
					listContract.add(new ContractEmployee(name, Rate.CONTRACT_PROFI.getSkillsRate()));
					break;

				}
			}
		
			if (Integer.parseInt(i) == 3) {
				for (SalariedEmployee x : listSalary) {
				
					System.out.println(x);
				}
				for (ContractEmployee x : listContract) {
					System.out.println(x);
									}
				break;

			}
			
		}	reader.close();
	}
}
