package homework2.student;

/**
 * Created by roma on 04.10.2016.
 */
public class Main {
    public static void main(String[] args){
        Student student1 = new Student("Olia", 5);
        Student student2 = new Student("Roman", 4);
        Student student3 = new Student();
        student3.setName("Toma");
        student3.setRating(4);

        System.out.println("Out students:");
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        System.out.print("student1 better student2: ");
        System.out.println(student1.betterStudent(student2));

        System.out.printf("Average rating of all students %.3f",Student.getAvgRating());
    }
}
