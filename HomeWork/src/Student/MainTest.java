package Student;

/**
 * Created by evil on 04.10.16.
 */
public class MainTest {
    public static void main(String[] args) {
        Student pif = new Student("Yura", 4.5);
        Student fill = new Student("Fill", 3.4);
        Student jim = Student.getStudent();
        jim.setName("Jim");
        jim.setRating(3.3);
        StudentGroup.sumAvgRating();
        System.out.println(pif.toString() + " " + fill.toString() + " " + jim.toString());
        StudentGroup.printGroupInfs();
        pif.changeRating(2.3);
        System.out.println(pif.toString());
        StudentGroup.printGroupInfs();
    }
}
