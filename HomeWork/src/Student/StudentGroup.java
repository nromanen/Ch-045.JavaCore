package Student;

/**
 * Created by evil on 05.10.16.
 */
class StudentGroup {
    private static double avgRating;
    private static double totalRating;
    private static int countStudent;

    public static void haveNewStudent(){
        countStudent++;
    }
    public static void setTotalRating(double rating){
        totalRating += rating;
    }

    //use this method when change rating for student
    public static void changeTotalRating(double newStudentRating){
        totalRating -= newStudentRating;
        sumAvgRating();
    }
    public static void sumAvgRating (){
        if (countStudent>1){avgRating = totalRating / countStudent;}

    }
    public static boolean betterStudent(Student obj, Student o){
        return obj.getRating() > o.getRating();
    }

    public static void printGroupInfs(){
        System.out.println("We have " + StudentGroup.countStudent + " students."
                            + " Total rating is: " + StudentGroup.totalRating
                            + " Average rating is: " + StudentGroup.avgRating);
    }
}
