package hohework5.practical.animal;

/**
 * Created by roma on 13.10.2016.
 */
public class Dog implements Animal {
     public String name;

    public Dog(String name){
        this.name = name;
    }

    @Override
    public String voice() {
        return "gav-gav";
    }

    @Override
    public String feed() {
        return "dog food";
    }
    @Override
    public String toString(){
        return String.format("Name: %-8s voice: %-12s feed: %-9s",name,this.voice(),this.feed());
    }
}
