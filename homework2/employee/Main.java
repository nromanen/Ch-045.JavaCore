package homework2.employee;

/**
 * Created by roma on 05.10.2016.
 */
public class Main {
    public static void main(String[] args){
        //use constructor empty
        Employee employee1 = new Employee();
        employee1.setName("first");
        employee1.setRate(100);
        employee1.setHours(8);

        //use constructor with 2-parameters
        Employee employee2 = new Employee("second", 120);
        employee2.setHours(6);

        //use constructor with 3-parameters
        Employee employee3 = new Employee("third", 130, 7);

        employee2.changeRate(150);

        System.out.println(employee1 + " salary=" + employee1.salary(Employee.bonuses));
        System.out.println(employee2 + " salary=" + employee2.salary());
        System.out.println(employee3 + " salary=" + employee3.salary());

        System.out.println("Total hours of all workers : " + Employee.totalHours);
        System.out.println("Total sum : " + Employee.totalSum);

    }
}
