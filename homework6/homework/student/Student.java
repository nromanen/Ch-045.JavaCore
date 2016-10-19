package homework6.homework.student;

/**
 * Created by roma on 19.10.2016.
 */
public class Student {
    private String name;
    private Integer course;

    public Student() {}

    public Student(String name, Integer course){
        this.name = name;
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!course.equals(student.course)) return false;
        if (!name.equals(student.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + course.hashCode();
        return result;
    }

    @Override
    public String toString(){
        return String.format("name - %-8s course - %-3d\n",name,course);
    }
}
