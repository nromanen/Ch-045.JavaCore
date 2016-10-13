package net.gavrilyuk.student;

/**
 * Student model Class
 * todo I am not a supporter of calculating the average and total rating in the model class.
 * todo Implemented for clarity with static fields and methods!
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class Student {

    private static int sCount = 0;
    private static int sSumRating = 0;

    private String name;
    private int rating;


    public Student() {
        sCount++;
    }

    public Student(String name) {
        this.name = name;
        sCount++;
    }

    public Student(String name, int rating) {
        sCount++;
        sSumRating += rating;
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
        sSumRating += rating;
    }

    public static double getAvgRating() {
        return (sCount == 0) ? 0 : (double) sSumRating / sCount;
    }

    public boolean betterStudent(Student student) {
        return this.getRating() > student.getRating();
    }

    public void changeRating(int newRating) {
        sSumRating = (sSumRating - rating) + newRating;
        this.rating = newRating;
    }

    public static int getTotalRating() {
        return sSumRating;
    }

    @Override
    public String toString() {
        return "Student [Name=" + name + ", Rating=" + rating + "]";
    }
}






