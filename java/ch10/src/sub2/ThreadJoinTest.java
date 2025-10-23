package sub2;
/*
 * date 25 0724
 * name minsu choi
 * text Thread state prectice
 */

class WorkThrea extends Thread {
	
	@Override
	public void run() {
		for(int i=1 ; i<=3 ; i++) {
			try {Thread.sleep(500);
			} catch (InterruptedException e) {e.printStackTrace();}
			
			System.out.println("WorkThread - " + i);
		}
	}
}

public class ThreadJoinTest {
	public static void main(String[] args) {
		
		WorkThrea work = new WorkThrea();
		
		work.start(); //좀비 스레드(자원o기능x)
		
		// 작업스레드 종료 대기(main이 작업 스레드를 기다림!)
		try {work.join();
		} catch (InterruptedException e) {
			e.printStackTrace();}
		
		//부모(main)이 끝났는데 자식이 실행됨!
		System.out.println("P/G exit..."); 
	}//med
} //ed
