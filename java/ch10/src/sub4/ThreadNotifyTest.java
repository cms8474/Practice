package sub4;
/*
 * date 25 0724
 * name minsu choi
 * text Thread Notify prectice
 */

class WorkObject{
	public synchronized void method1() {
		Thread th = Thread.currentThread();
		System.out.println(th.getName() + " - method1 실행");
		
		//다른 스레드를 실행상태로 전환
		notify();
		
		try {wait(); // 자신은 일시정지로
		} catch (InterruptedException e) {
			e.printStackTrace();}
	} //1ed
	
	public synchronized void method2() {
		Thread th = Thread.currentThread();
		System.out.println(th.getName() + " - method2 실행");
		
		//다른 스레드를 실행상태로 전환
		notify();
		
		try {wait(); // 자신은 일시정지로
		} catch (InterruptedException e) {
			e.printStackTrace();}
	} //2ed
}

class ThreadA extends Thread {
	private WorkObject work;
	public ThreadA(WorkObject work) {
		this.work = work;
		setName("ThreadA");//부모클래스 메서드 이름 초기화
	}
	@Override
	public void run() {
		for (int i=0 ; i<10 ; i++) {
			work.method1();}
	}
}
class ThreadB extends Thread {
	private WorkObject work;
	public ThreadB(WorkObject work) {
		this.work = work;
		setName("ThreadA");//부모클래스 메서드 이름 초기화
	}
	@Override
	public void run() {
		for (int i=0 ; i<10 ; i++) {
			work.method2();}
	}
}

public class ThreadNotifyTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WorkObject work = new WorkObject();
		
		ThreadA thA = new ThreadA(work);
		ThreadB thB = new ThreadB(work);
		
		thA.start();
		thB.start();
		
		thA.join();
		thB.join();
		
		
		System.out.println("종료");
	}

}
