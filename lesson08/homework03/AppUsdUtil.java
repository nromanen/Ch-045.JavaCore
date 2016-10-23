package lesson08.homework03;

/* Implement a pattern for US currency: the first symbol "$", then any number of digits, dot and two 
 * digits after the dot. Enter the text from the console that contains several occurrences of US currency. 
 * Display all occurrences on the screen.
 */
public class AppUsdUtil {
	public static void main(String[] args) {
		UsdUtil util = new UsdUtil();
		System.out.println("Please enter text, that contains several occurrences of US currency: ");
		util.printUsd(util.inputString());

		String str = "$789.11, price" + "$56789,45,  " + "$23134123.433";
		util.printUsd(str);
	}
}
