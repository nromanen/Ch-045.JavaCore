package startabstract;

public class Teacher extends Staff {
	private static final String TYPE_PERSON = "Teacher";

	public Teacher() {
	}

	@Override
	void print() {
		System.out.println("I am a " + TYPE_PERSON);

	}

	@Override
	public void salary() {
		System.out.println("My salary is 4000");

	}

}
