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

    private String mName;
    private int mRating;


    public Student() {
        sCount++;
    }

    public Student(String name) {
        this.mName = name;
        sCount++;
    }

    public Student(String name, int rating) {
        sCount++;
        sSumRating += rating;
        mName = name;
        mRating = rating;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public int getRating() {
        return mRating;
    }

    public void setRating(int rating) {
        this.mRating = rating;
        sSumRating += rating;
    }

    public static double getAvgRating() {
        return (sCount == 0) ? 0 : (double) sSumRating / sCount;
    }

    public boolean betterStudent(Student student) {
        return this.getRating() > student.getRating();
    }

    public void changeRating(int newRating) {
        sSumRating = (sSumRating - mRating) + newRating;
        this.mRating = newRating;
    }

    public static int getTotalRating() {
        return sSumRating;
    }

    @Override
    public String toString() {
        return "Student [Name=" + mName + ", Rating=" + mRating + "]";
    }
}






