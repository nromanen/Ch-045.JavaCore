package Person;

/**
 * Created by evil on 06.10.16.
 */
public class MainPerson {
    public static void main(String[] args) {
        Person newPerson = new Person("Yura", "04-05-1989");
        Person fill = new Person();
        Person someone = new Person("someone", "05-12-1990");
        fill.setName("Fill"); fill.setBirthYear("04-02-1965");
        System.out.println(newPerson.toString() + System.lineSeparator()
                            + fill.toString() + System.lineSeparator()
                            + someone.toString());
    }
}
