package homework6.practical.task2;

/**
 * Created by roma on 19.10.2016.
 */
public class Employee {
    private int id;
    private String name;

    public Employee(){}

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
