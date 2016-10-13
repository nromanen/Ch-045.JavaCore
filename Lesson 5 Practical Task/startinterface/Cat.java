package startinterface;

public class Cat implements Animal{
public String name;
public Cat(String name){
	this.name = name;
}
	@Override
	public void voice() {
		System.out.println(this.name + " says miau");
	}

	@Override
	public void feed() {
		System.out.println(this.name + " eats Fish");
		
	}

}
