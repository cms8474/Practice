package sub8;

// 인터페이스는 메서드 정의 자체가 안 됨(선언 이후 로직 작성 불가)
// 클래스 구현을 위한 추상 메서드만 갖는 구조체
public interface RemoteControl {
	
	public abstract void powerOn();
	public abstract void powerOff();
	
	public void chUp(); // abstract 생략!
	public void chDown();
	
	public void sonudUp();
	public void soundDown();
	

}
