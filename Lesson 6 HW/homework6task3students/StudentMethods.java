package homework6task3students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

public class StudentMethods {
	public static void printStudentsbyCourse(Map<String, Integer> list, int course) {
		Iterator<Map.Entry<String, Integer>> iterator = list.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = iterator.next();
			int studcourse = pair.getValue();
			String nameD = pair.getKey();
			if (studcourse == course) {
				System.out.println("Student from the course " + course + " is - " + nameD);
			}
		}
	}

	public static Comparator<Student> compareByName = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {

			return o1.getFullName().compareTo(o2.getFullName());
		}

	};

	public static Comparator<Student> compareByCourse = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			if (o1.getCourse() > o2.getCourse()) {
				return 1;
			} else if (o1.getCourse() == o2.getCourse()) {
				return 0;
			} else
				return -1;
		}
	};
}
