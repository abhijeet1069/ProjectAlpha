package cherno.test;

public class Test implements Runnable{

	String message;
	
	Test(String message){
		this.message = message;
	}
	public void print(String message) {
		for(int i = 0; i < 100; i++) {
			System.out.println(message);
		}
		
	}
	
	@Override
	public void run() {
		print(this.message);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Test test1 = new Test("Hello Thread1");
		Thread thread1 = new Thread(test1);
		thread1.start();
		thread1.join();
		Test test2 = new Test("Hello Thread2");
		Thread thread2 = new Thread(test2);
		thread2.start();
	}
}
