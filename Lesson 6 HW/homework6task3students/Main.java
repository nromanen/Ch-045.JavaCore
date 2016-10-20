package homework6task3students;

/*Write class Student that provides information about the name of the student and his course.
 *  Class Student should consists of: properties for access to these fields
constructor with parameters method printStudents (List students, Integer course), 
which receives a list of students and the course number and prints to the console the names of the students from the list,
 which are taught in this course (use an iterator);
- methods to compare students by name and by course
In the main() method 
declare List students and add to the list five different students
display the list of students ordered by name
display the list of students ordered by course. */
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Map<String, Integer> listOfStudents = new HashMap<>();
		 ArrayList<Student> Studentslist = new ArrayList<>();
		Student stud1 = new Student("Kaskin Stas", 1);
		Student stud2 = new Student("Kakaskin Vlad", 2);
		Student stud3 = new Student("Izumin Stas", 2);
		Student stud4 = new Student("Kaskin Andrey", 3);
		Student stud5 = new Student("Zigmund Ilona", 3);
		
		Studentslist.add(stud1);
		Studentslist.add(stud2);
		Studentslist.add(stud3);
		Studentslist.add(stud4);
		Studentslist.add(stud5);
		Studentslist.add(new Student("Kazimirov Anton", 4));
		Studentslist.add(new Student("Kazarmov Anton", 3));
		Studentslist.add(new Student("Kizimov Anton", 2));
		Studentslist.add(new Student("Krov Anton", 4));
		Studentslist.add(new Student("Kirov Anton", 5));
		
		
		listOfStudents.put(stud1.getFullName(), stud1.getCourse());
		listOfStudents.put(stud2.getFullName(), stud2.getCourse());
		listOfStudents.put(stud3.getFullName(), stud3.getCourse());
		listOfStudents.put(stud4.getFullName(), stud4.getCourse());
		listOfStudents.put(stud5.getFullName(), stud5.getCourse());

	StudentMethods.printStudentsbyCourse(listOfStudents, 3);
	Collections.sort(Studentslist, StudentMethods.compareByName);
   System.out.println(Studentslist);
   Collections.sort(Studentslist, StudentMethods.compareByCourse);
   System.out.println(Studentslist);
	}
}
