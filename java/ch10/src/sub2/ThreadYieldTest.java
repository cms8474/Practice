package sub2;
/*
 * date 25 0724
 * name minsu choi
 * text Thread Yield(양보) prectice
 */

class Sub1Thread extends Thread{

	public void run() {
		for(int i=1 ; i<1000 ; i++) {
			System.out.println("Sub1Thread - " + i);
			Thread.yield(); // 스레드 양보
		}
	}
}


class Sub2Thread extends Thread{
	public void run() {
		for(int i=1 ; i<1000 ; i++) {
			System.out.println("Sub2Thread - " + i);
			// yield() 양보 없음
		}
	}
}

public class ThreadYieldTest {
	public static void main(String[] args) throws InterruptedException {
			
		Sub1Thread s1 = new Sub1Thread();
		Sub2Thread s2 = new Sub2Thread();
		
		s1.start();
		s2.start();
		
		s1.join();
		s2.join();
		
	}//med
}//ㄷㅇ
