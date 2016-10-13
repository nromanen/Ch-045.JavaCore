package startabstract;

public class Student extends Person {
	private static final String TYPE_PERSON = "Student";

	public Student() {
	}

	@Override
	void print() {
		System.out.println("I am a " + TYPE_PERSON);

	}

}
