package homework6.homework.person;

/**
 * Created by roma on 19.10.2016.
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(){}

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString(){
        return "Name - "+firstName+" lastName - "+lastName;
    }
}
