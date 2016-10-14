package hohework5.practical.person;

/**
 * Created by roma on 14.10.2016.
 */
public class Student extends Person {

    public static String TYPE_PERSON = Student.class.getSimpleName();

    public Student(){}

    public Student(String name){
        super(name);
    }

    @Override
    public String  print() {
        return  "I am "+TYPE_PERSON;
    }
    @Override
    public String toString(){
        return String.format("name: %-8s type: %-15s",name,this.print());
    }
}
