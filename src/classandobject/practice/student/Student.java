package classandobject.practice.student;

public class Student {

    private String name;
    private double rating = 3;

    {
        Group.students.add(this);
    }

    public Student (){
        this.name = "unknown Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, double rating) {
        this(name);
        if (rating > 0 && rating <=5) {
            this.rating = rating;
        } else {
            this.rating = 3;
        }
    }
    
    //seters and geters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }


    //Method compare two students by rating
    public boolean betterStudent(Student student){
        return this.rating > student.rating;
    }

    //Method allows change student's rating
    public void changeRating(double rating){
        if (rating > 0 && rating <=5) {
            this.rating = rating;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", rating: " + rating + ".";
    }

}
