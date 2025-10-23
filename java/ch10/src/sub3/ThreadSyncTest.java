package sub3;
/*
 * date 25 0724
 * name minsu choi
 * text Thread Sync prectice
 */


public class ThreadSyncTest {
	public static void main(String[] args) throws InterruptedException {
		
		Count count = new Count();
		CountThread c1 = new CountThread(count);
		CountThread c2 = new CountThread(count);
		CountThread c3 = new CountThread(count);
		
		// 1~100 더해 * 3개
		c1.start();
		c2.start();
		c3.start();
		
		c1.join();
		c2.join();
		c3.join();
		
		System.out.println("최종 결과: " + count.getNum());
		
		
	}
}
