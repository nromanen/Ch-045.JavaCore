package Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evil on 17.10.16.
 */
public class DBPerson {
    private List<Person> persons = new ArrayList<Person>();

    public void addPerson (Person person){
        persons.add(person);
    }

    public void printPerson(){
        for (Person person : persons){
            person.print();
        }
    }
}
