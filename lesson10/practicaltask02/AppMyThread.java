package lesson10.practicaltask02;

/* Output two messages «Hello, world» and «Peace in the peace» 5 times each with the intervals of 2 seconds,
 *  and the second - 3 seconds. After printing messages, print the text «My name is …»
 */

public class AppMyThread {
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
		
	}
}
