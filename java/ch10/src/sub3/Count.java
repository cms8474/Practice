package sub3;

public class Count {
	private int num =0;
	
	public int getNum() {
		return num;
	}
	/*
	public void setNum() {
		this.num++;
	}*/
	
	//synchronized: 동기화 블럭, 스레드와 경합을 막고 순차적으로 실행
	public synchronized void setNum() {
		//임계영역: 하나의 스레드가 해당 영역에 들어올 때 Lock
		//       영역을 빠져나갈 때 임계영역 lock 해제.
		this.num++;
	}
}
