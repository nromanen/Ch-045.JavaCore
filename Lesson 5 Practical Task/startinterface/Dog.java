package startinterface;

public class Dog implements Animal{
	public String name;
	public Dog(String name){
		this.name = name;
	}

	@Override
	public void voice() {
		System.out.println(this.name + " does bark");
		
	}

	@Override
	public void feed() {
		System.out.println(this.name + " eat bone");
		
	}

}
