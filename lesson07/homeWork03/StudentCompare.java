package lesson07.homeWork03;

import java.util.Comparator;

public class StudentCompare {

	public static Comparator<Student> studentNameComparator = new Comparator<Student>() {

		public int compare(Student n1, Student n2) {
			String studentName1 = n1.getName().toUpperCase();
			String studentName2 = n2.getName().toUpperCase();
			return studentName1.compareTo(studentName2);

		}
	};

	public static Comparator<Student> courseRange = new Comparator<Student>() {

		public int compare(Student c1, Student c2) {
			if (c1.getCourse() - c2.getCourse() == 0) {
				return c1.getName().compareTo(c2.getName());
			}
			return c1.getCourse() - c2.getCourse();
		}
	};

}
