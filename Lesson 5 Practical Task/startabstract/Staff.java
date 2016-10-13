package startabstract;

public abstract class Staff extends Person {
	private final static String TYPE_PERSON = "Staff";

	@Override
	void print() {
		System.out.println("I am a " + TYPE_PERSON);
	}

	public abstract void salary();

}
