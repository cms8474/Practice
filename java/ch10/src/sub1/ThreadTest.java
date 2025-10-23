package sub1;

import java.security.PublicKey;

/*
 * date 25 0724
 * name minsu choi
 * text Thread prectice
 */

class SubThread extends Thread {
	public String name;
	public SubThread(String name) {
		this.name = name;
	};
	
	// 자식 스레드 실행
	@Override
	public void run() {
		for(int i=0 ; i<3 ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.name + "작업 스레드 실행: " + i);
		}
		System.out.println("작업 스레드 종료...");
		
	}


} //ced

public class ThreadTest {
	public static void main(String[] args) {
		//자식스레드 객체 생성
		SubThread st1 = new SubThread("1 ");
		SubThread st2 = new SubThread("2 ");
		
		// 작업스레드 실행
		st1.run();
		st2.run();
		
		for(int i=0 ; i<3 ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("메인 스레드 실행: " + i);
		}
		
		System.out.println("메인 스레드 종료");
		
		
	} //med
} //ed
