package lesson9homeworktask3;

public class Main {

	// public static int sum = 0;
	public static void main(String[] args) throws InterruptedException {
		Runnable r1 = new Run1();
		Thread t1 = new Thread(r1);
		
		t1.start();
		Runnable r3 = new Run3();
		Thread t3 = new Thread(r3);
		t3.start();
		
	
		System.out.println("Main thread ");
		
		
		
	}

}

class Run1 implements Runnable {
	@Override
	public void run() {
		Runnable r2 = new Run2();
		Thread t2 = new Thread(r2);
		t2.start();
		
		;
	}
}

class Run2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 3; i++)
			System.out.println("thread 2 running");
		;
	}
	
}
	
	class Run3 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 5; i++)
				System.out.println("thread 3 running");
			;
		}
}
