package abstracthomework1;

public class Chicken extends NonFlyingBird {
	private static final String BIRD_TYPE = "Chicken";

	@Override
	public void fly() {
		System.out.println(BIRD_TYPE + " I cant fly:)");
		info();
	}

	public void info() {

		System.out.println(BIRD_TYPE + "is a non-flying bird with average body length 40 sm,"
				+ " mass ~ 2 kg, can jump or fly on 1 meter");
	}
}
