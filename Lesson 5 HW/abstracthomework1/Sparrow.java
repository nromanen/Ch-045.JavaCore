package abstracthomework1;

public class Sparrow extends FlyingBird {
	boolean feathers;
	boolean layEggs;
	private static final String BIRD_TYPE = "Sparrow";

	public Sparrow() {
		   this.feathers = true;
		  this.layEggs = false;
	}

	@Override
	public void fly() {
		System.out.println(BIRD_TYPE + " I am profi, " + " has feathers - " + this.feathers + ", and lays eggs -" + this.layEggs);
		// info();
	}

	public void info() {
		System.out.println(BIRD_TYPE + "is a flying bird with average body length 10-20 cm,"
				+ " mass 15-40 gramms, wings width 20-40 cm, max flying speed up to 300 km/h");
	}

}
