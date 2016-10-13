package startabstract;

public class Cleaner extends Staff {
	private static final String TYPE_PERSON = "Cleaner";

	public Cleaner() {
	}

	@Override
	void print() {
		System.out.println("I am a " + TYPE_PERSON);

	}

	@Override
	public void salary() {
		System.out.println("My salary is 3000");
	}

}
