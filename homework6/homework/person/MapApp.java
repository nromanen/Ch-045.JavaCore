package homework6.homework.person;

/**
 * Created by roma on 19.10.2016.
 * Create map personMap and add to it ten persons of type <String, String> (lastName, firstName).
        Output the entities of the map on the screen.
        There are at less two persons with the same firstName among these 10 people?
        Remove from the map person whose firstName is ”Orest” (or other). Print result.

 */
public class MapApp {
    public static void main(String[] args){

        Person person1,person2,person3,person4,person5;
        person1 = new Person("user","admin");
        person2 = new Person("user", "user1");
        person3 = new Person("root", "super");
        person4 = new Person("sudo", "super_su");
        person5 = new Person("dir","select");
        
        PersonMap personMap = new PersonMap();
        personMap.putPersonToMap(person1);
        personMap.putPersonToMap(person2);
        personMap.putPersonToMap(person3);
        personMap.putPersonToMap(person4);
        personMap.putPersonToMap(person5);

        personMap.printPersonMap();

        personMap.removePerson("sudo");

        System.out.println("After remote user");
        personMap.printPersonMap();
    }

}
