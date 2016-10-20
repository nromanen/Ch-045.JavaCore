package homework6.homework.student;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by roma on 19.10.2016.
 */
public class StudentUtil {
    private List<Student> student;

    public StudentUtil() {
    }

    public StudentUtil(List<Student> student) {
        this.student = student;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public void addStudent(Student student){
        this.student.add(student);
    }
    public String printStudents(List<Student> listStudent, Integer course){
        StringBuilder sb = new StringBuilder();
        sb.append(headList());
        for(Student student: listStudent ){
            if(student.getCourse() == course){
                sb.append(student);
            }
        }
        return sb.toString();
    }
    public void insertFields(int countFields){
        student = new LinkedList<>();
        String[] name = {"Bill","Adam","Troll","Eco","Hill",};
        int[] course = {2,3,1,4,5};
        for(int i=0; i<name.length; i++){
            student.add(new Student(name[i],course[i]));
        }
    }
    public String printList(){
        StringBuilder sb = new StringBuilder();
        sb.append(headList());
        for (Student st: student ){
            sb.append(st);
        }
        return sb.toString();
    }
    public String headList(){
        return String.format("%-10s%-10s\n","name","course");
    }
}
