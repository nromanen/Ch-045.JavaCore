package abstracthomework1;

public class Eagle extends FlyingBird {
	boolean feathers;
	boolean layEggs;
	private static final String BIRD_TYPE = "Eagle";
	
	public Eagle() {
		this.feathers = true;
		this.layEggs = true;
	}

	@Override
	public void fly() {
		System.out.println(BIRD_TYPE + " Show me a target!" + " has feathers - " + this.feathers + ", and lays eggs -" + this.layEggs);
		// info();
	}

	@Override
	public void info() {

		System.out.println(BIRD_TYPE + "is a flying bird with average body length - 1 meter,"
				+ " mass ~ 6 kg, wings width ~ 2 meters, max flying speed up to 400 km/h");
	}

}
