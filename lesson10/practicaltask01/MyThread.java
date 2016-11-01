package lesson10.practicaltask01;

public class MyThread implements Runnable {

	int number;
	int pause;

	public MyThread(int number, int pause) {
		this.number = number;
		this.pause = pause;
	}

	@Override
	public void run() {
		for (int i = 0; i < number; i++) {
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
			}
			System.out.println("I study Java " + i);
		}

	}

}
