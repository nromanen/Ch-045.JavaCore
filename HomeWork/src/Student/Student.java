package Student;

/**
 * Created by evil on 04.10.16.
 */
class Student {
    private String name;
    private double rating;

    private Student(){StudentGroup.haveNewStudent();}
    public Student(String name, double rating){
        this.name = name;
        this.rating = rating;
        StudentGroup.haveNewStudent();              //count student
        StudentGroup.setTotalRating(this.rating);   //count total rating

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static Student getStudent(){
        return new Student();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
        StudentGroup.setTotalRating(this.rating);
    }
    public void changeRating(double newRating){
        this.rating = newRating;
        StudentGroup.changeTotalRating(this.rating);
    }
}
