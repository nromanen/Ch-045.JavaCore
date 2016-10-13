package abstracthomework1;

public class Penguin extends NonFlyingBird {
	private static final String BIRD_TYPE = "Penguin";
	@Override
	public void fly() {
System.out.println( BIRD_TYPE + " If I could fly(");
info();
	}
	public void info()
	{
		
	System.out.println(BIRD_TYPE + "is a non-flying bird with average body length 1 m,"
				+ " mass ~ 35 kg, and walking not so fast)");
	}
}
