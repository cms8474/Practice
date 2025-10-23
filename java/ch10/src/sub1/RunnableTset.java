package sub1;

class Task implements Runnable{
	@Override
	public void run() {
		for(int i=0 ; 1<10 ; i++) {
			System.out.println("Task 실행");
			
			try {Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();}
		}
	}
}

public class RunnableTset {
	public static void main(String[] args) {
		Task t1 = new Task();
		Task t2 = new Task();
		Thread tr1 = new Thread(t1);
		Thread tr2 = new Thread(t2);
		
		tr1.start();
		tr2.start();
		
		System.out.println("ED");
	}
}
