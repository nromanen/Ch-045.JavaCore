package abstracthomework1;

public class Sparrow extends FlyingBird {
	private static final String BIRD_TYPE = "Sparrow";
public Sparrow(){
	//private String feathers = "";
	//private boolean layEggs;
}	
	@Override
	public void fly() {
System.out.println( BIRD_TYPE + " I am profi");
info();
	}
	public void info()
	{
		System.out.println(BIRD_TYPE + "is a flying bird with average body length 10-20 cm,"
				+ " mass 15-40 gramms, wings width 20-40 cm, max flying speed up to 300 km/h");
	}


}

