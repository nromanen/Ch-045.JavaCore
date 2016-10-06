package homework2.person;

import java.util.*;

/**
 * Created by roma on 05.10.2016.
 */
public class Person {
    
    static int number;
    static GregorianCalendar today = new GregorianCalendar();
    private String name;
    private int birthYear;
    public Collection<Person> persons;

    public Person(){
    }

    public Person(String name, int birthYear){
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int agePerson(){
        return  Person.today.getWeekYear() - this.birthYear ;
    }

    public String toString(){
        return String.format("[Name: %-10s age: %5d ]\n", this.name,this.agePerson());
    }

    public void input(){
        Person.number = inputInt("Enter number of person ");
        persons = new LinkedList<Person>();
        for (int i=0; i<number; i++){
            persons.add(inputPerson());
        }
    }
    public Person inputPerson(){
        String name = inputName("Enter name ");
        int dateUser = inputInt("Enter birthYear ");
        System.out.print("--------------------------\n");
        return new Person(name,dateUser );
    }

    public void output(){
        for(Person person: persons){
            System.out.print(person);
        }
    }

    public static String inputName(String message){
        Scanner scan = new Scanner(System.in);
        System.out.print(message + ":");
        String rez = scan.next();
        return rez;
    }
    public static int inputInt(String message) {
        int result = 0;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            while(!scan.hasNextInt()){
                System.out.print("error format: ");
                scan.next();
            }
            result = scan.nextInt();
        } while (result <= 0);
        return result;
    }
}
