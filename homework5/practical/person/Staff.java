package hohework5.practical.person;

/**
 * Created by roma on 14.10.2016.
 */
public abstract class Staff extends Person {

    public Staff(){}

    public Staff(String name){
        super(name);

    }

    public abstract int salary();

    @Override
    public String toString(){
        return String.format("name: %-8s type: %-15s salary: %-6d",name,print(),salary());
    }
}
