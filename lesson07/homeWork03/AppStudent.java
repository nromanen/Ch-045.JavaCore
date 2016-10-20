package lesson07.homeWork03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Write class Student that provides information about the name of the student and his course. 
 * Class Student should consists of
 * a) properties for access to these fields;
 * b) constructor with parameters;
 * c) method printStudents (List students, Integer course), which receives a list of students and 
 * the course number and prints to the console the names of the students from the list, which are taught 
 * in this course (use an iterator);
 * d) methods to compare students by name and by course;
 * e) In the main() method: 
 * - declare List students and add to the list five different students
 * - display the list of students ordered by name
 * - display the list of students ordered by course.
 */

public class AppStudent {

	public static void main(String[] args) {
		StudentUtil student = new StudentUtil();
		List<Student> list = new ArrayList<Student>();
		student.setStudent(list);

		System.out.println("Students, ranged by cours 4: ");
		student.printStudents(list, 4);

		System.out.println("\n" + "Students, sorted by course: ");
		Collections.sort(list, StudentCompare.courseRange);
		for (Student in : list) {
			System.out.println(in);
		}

		System.out.println("\n" + "Students, sorted by name: ");
		Collections.sort(list, StudentCompare.studentNameComparator);
		for (Student in : list) {
			System.out.println(in);
		}

	}

}
