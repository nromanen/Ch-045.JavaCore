package database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class EmployeeService {

    private static List<Integer> SSNList = new ArrayList<>();

    public static int getSSN(){
        boolean isCorrect = false;
        int ssn = 0;
        while (!isCorrect) {
            ssn = (int) (Math.random() * 1000000);
            if (!SSNList.contains(ssn)){
                SSNList.add(ssn);
                isCorrect = true;
            }
        }
        return ssn;
    }

    Comparator<Employee> compareByLastName = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {

            return o1.getLastName().compareTo(o2.getLastName());
        }
    };

    Comparator<Employee> compareByFirstRate = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {

            return (int)(o1.getRate() - o2.getRate());
        }
    };

    Comparator<Employee> compareByPosition = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {

            return o1.getPosition().ordinal() - o2.getPosition().ordinal();
        }
    };

    Comparator<Employee> compareByAge = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {

            return o1.getAge() - o2.getAge();
        }
    };



}
