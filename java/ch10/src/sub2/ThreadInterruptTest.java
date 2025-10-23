package sub2;
/*
 * date 25 0724
 * name minsu choi
 * text Thread Interrupt prectice
 */

class SubThread extends Thread {
	private static final boolean True = false;

	@Override
	public void run() {
		int i = 1;
		while(true){
			try {
				System.out.println("SubThread : " + i);
				i++;
				Thread.sleep(1000); //1초 일시정지
				} catch (InterruptedException e) {
					e.printStackTrace();}
		}
	}
}

public class ThreadInterruptTest {
	public static void main(String[] args) {
		
		SubThread sub = new SubThread();
		sub.start();
		
		//main 5초 대기

		try {Thread.sleep(1000*5); //메인 스레드 5초 정지
		} catch (InterruptedException e) {
			e.printStackTrace();} 
		
		// 작업 스레드 일시정지 발생
		// 보조스레드가 sleep 할 때 발생(보조 i가 5일때)
		sub.interrupt();
		
		System.out.println("p/g ed");
	}
}
