package abstracthomework1;

public class Penguin extends NonFlyingBird {
	boolean feathers;
	boolean layEggs;
	private static final String BIRD_TYPE = "Penguin";
	
	public Penguin(){
		this.feathers = false;
		this.layEggs = true;
	}

	@Override
	public void fly() {
		System.out.println(BIRD_TYPE + " If I could fly(" + " has feathers - " + this.feathers + ", and lays eggs -" + this.layEggs);
		// info();
	}

	public void info() {

		System.out.println(BIRD_TYPE + "is a non-flying bird with average body length 1 m,"
				+ " mass ~ 35 kg, and walking not so fast)");
	}
}
