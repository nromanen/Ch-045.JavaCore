package homework2.student;

/**
 * Created by roma on 04.10.2016.
 */
public class Student {
    private static int sum = 0;
    private static int countStudent = 0;
    private String name;
    private int rating;

    public Student(){
        countStudent++;
    }

    public Student(String name, int rating){
        this.rating = rating;
        this.name = name;
        countStudent++;
        sum +=rating;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setRating(int rating){
        this.rating = rating;
        sum +=rating;
    }

    public int getRating() {
        return rating;
    }

    public static double getAvgRating(){
        return (double) sum/countStudent;
    }
    public boolean betterStudent(Student student){
        return this.getRating() > student.getRating();
    }
    public void changeRating(int rating){
        this.rating = rating;
    }
    @Override
    public  String toString(){
        return "Student [name = "+name+", rating = "+rating+"]";
    }
}

