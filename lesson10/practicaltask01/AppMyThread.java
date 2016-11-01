package lesson10.practicaltask01;

/* Output text «I study Java» 10 times with the intervals of one second (Thread.sleep(1000);).
 */
public class AppMyThread {
	public static void main(String[] args) {

		MyThread myThread = new MyThread(10, 1000);
		Thread thread = new Thread(myThread);
		thread.start();
	}
}
