package lesson07.homeWork03;

import java.util.Iterator;
import java.util.List;

public class StudentUtil {

	public void setStudent(List<Student> list) {
		list.add(new Student("Ann", 3));
		list.add(new Student("Sam", 1));
		list.add(new Student("Kate", 4));
		list.add(new Student("Alison", 2));
		list.add(new Student("Peter", 5));
		list.add(new Student("Mark", 1));
		list.add(new Student("Tom", 2));
		list.add(new Student("Ketrin", 3));
		list.add(new Student("Ostin", 4));
		list.add(new Student("Jane", 4));
	}

	public void printStudents(List<Student> list, int course) {
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student key = it.next();
			if (key.getCourse() == (int) course) {
				System.out.println(key);
			}
		}
	}
}
