package lesson08.practicalTask01;

/* Enter the two variables of type String. Determine whether the first variable substring second. 
 * For example, if you typed «IT» and «IT Academy» you must receive true.
 */
public class AppValue {
	public static void main(String[] args) {
		Value value1 = new Value();
		String variable1 = "IT";
		String variable2 = "IT Academy";
		String variable3 = "Java";
		System.out.println(variable1 + " substring " + variable2 + ": " + value1.containsValue(variable1, variable2));
		System.out.println(variable1 + " substring " + variable3 + ": " + value1.containsValue(variable1, variable3));
		System.out.println(variable2 + " substring " + variable1 + ": " + value1.containsValue(variable2, variable1));

	}
}
