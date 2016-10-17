package Person;

/**
 * Created by evil on 17.10.16.
 */
public class AppMainPerson {
    public static void main(String[] args) {
        DBPerson person = new DBPerson();
        person.addPerson(new Student("Pif"));
        person.addPerson(new Teacher("Ann", 2000));
        person.addPerson(new Cleaner("Tim", 2000));
        person.printPerson();
    }
}
