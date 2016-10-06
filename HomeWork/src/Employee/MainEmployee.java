package Employee;

/**
 * Created by evil on 06.10.16.
 */
public class MainEmployee {
    public static void main(String[] args) {
        Employee fill = new Employee("Fill", 3.4, 4);
        Employee pif = new Employee("Yura", 4.5, 5);
        Employee rick = new Employee("Rick", 5.6, 9);
        System.out.println(pif.toString() + System.lineSeparator()
                            + fill.toString() + System.lineSeparator()
                            + rick.toString());
        System.out.println("Total sum " + Employee.getTotalSum());
        fill.setTotalSum();
        pif.setTotalSum();
        rick.setTotalSum();
        System.out.println("Total sum = " + Employee.getTotalSum() + " hours");
        pif.changeRate(13.3);
        System.out.println(pif.toString());
    }
}
