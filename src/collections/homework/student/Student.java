package collections.homework.student;

import java.util.ArrayList;

public class Student {

    private String fullName;
    private int age;
    private ArrayList<Double> notes =  new ArrayList<>();
    private int course;

    {
        Facultet.students.add(this);
    }

    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        this.course = 1;
    }

    public Student(String fullName, int age, double... notes) {
        this(fullName, age);
        for (double note : notes) {
            this.notes.add(note);
        }

    }

    public Student(String fullName, int age, int course, double... notes ) {
        this(fullName, age, notes);
        this.course = course;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Double> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Double> notes) {
        this.notes = notes;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double averageRating(){
        double result = 0d;

        for (Double note : notes) {
            result += note;
        }
        return result/notes.size();
    }

    public boolean passExams(){
        if (averageRating() >= 3){
            return true;
        }
        return false;
    }

    public boolean courseUp(){
        if (passExams()){
            if (course != 5) {
                course++;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (getAge() != student.getAge()) return false;
        if (getCourse() != student.getCourse()) return false;
        return !(getFullName() != null ? !getFullName().equals(student.getFullName()) : student.getFullName() != null);

    }

    @Override
    public int hashCode() {
        int result = getFullName() != null ? getFullName().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + getCourse();
        return result;
    }

    @Override
    public String toString() {
        return "I'm a student, my name is " + fullName +", I'm " + age + " years old, I'm on " + course + " course.";
    }
}
