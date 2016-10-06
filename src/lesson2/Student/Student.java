package lesson2.student;

public class Student {

    private static int count = 0;
    public static double avrRating = 0.0;

    private String name;
    private double rating = 0;

    {
        count++;
    }

    public Student (){
        this.name = "unknown Student";
        avrRating = (avrRating * (count - 1) + this.rating) / count;
    }

    public Student(String name) {
        this.name = name;
        avrRating = (avrRating * (count - 1) + this.rating) / count;
    }

    public Student(String name, double rating) {
        this.name = name;
        this.rating = rating;
        avrRating = (avrRating * (count - 1) + this.rating) / count;
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

    private void setRating(double rating) {
        this.rating = rating;
    }

    public boolean betterStudent(Student student){
        return this.rating > student.rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    public void changeRating(double rating){
        if (rating > 0 && rating <=5) {
            avrRating = (avrRating * count - this.rating + rating) / count;
            this.rating = rating;
        }
    }


}
