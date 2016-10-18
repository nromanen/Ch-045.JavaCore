package net.gavtilyuk.task3;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class Student  {

    private static final int UNKNOWN_COURSE = 0;

    private String name;
    private int course;

    public Student(String name, int course) throws StudentException{
        if (null==name || name.isEmpty())  throw new StudentException(1, "name must be not empty!");
        if (course<0)  throw new StudentException(2, "course must be positive!");
        this.name = name;
        this.course = course;
    }

    public Student(String name) {
        this(name, UNKNOWN_COURSE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws StudentException {
        if (null==name || name.isEmpty())  throw new StudentException(1, "name must be not empty!");
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) throws StudentException {
        if (course<0)  throw new StudentException(2, "course must be positive!");
        this.course = course;
    }

    public boolean compareByName(Student other) {
       return this.getName().equalsIgnoreCase(other.getName());
    }

    public boolean compareByCourse(Student other) {
        return this.getCourse()==(other.getCourse());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        if (getCourse() != student.getCourse()) return false;
        return getName().equals(student.getName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCourse();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", course=" + course +"}\n";
    }




}
