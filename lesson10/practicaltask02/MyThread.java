package lesson10.practicaltask02;

public class MyThread implements Runnable {

	public MyThread() {

	}

	@Override
	public void run() {

		method1();
		method2();
		method3();
	}

	public synchronized void method1() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("Hello, world.");
		}
	}

	public synchronized void method2() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("Peace in the peace.");
		}
	}

	public synchronized void method3() {
		
		System.out.println("My name is Volodymyr");
	}

}
