package hohework5.practical.animal;

/**
 * Created by roma on 13.10.2016.
 */
public class Cat implements Animal {
    public String name;

    public Cat(String name){
        this.name = name;
    }

    @Override
    public String voice() {
        return "mau mau mau";
    }

    @Override
    public String feed() {
        return "cat food";
    }
    @Override
    public String toString(){
        return String.format("Name: %-8s voice: %-12s feed: %-9s",name,this.voice(),this.feed());
    }
}
