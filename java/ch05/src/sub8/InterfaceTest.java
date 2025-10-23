package sub8;

public class InterfaceTest {
	
	public static void main(String[] args) {
		// 인터페이스 역할 - 통일된 표준 클래스 설계
		RemoteLG lg = new RemoteLG();
		lg.powerOn();
		lg.chUp();
		lg.soundDown();
		lg.powerOff();
		
		
		RemoteSamsung samsung = new RemoteSamsung();
		samsung.powerOn();
		samsung.chUp();
		samsung.sonudUp();
		samsung.powerOff();
		
		// 인터페이스 역할2 - 결합도 완화(유연성)
		Bulb bulb = new Bulb();
		Socket socket= new Power(bulb);
		
		socket.switchOn();
		socket.switchOff();
		
		
		// 인터페이스 역할3 - 다중 상속효과(클래스 상속 + 인터페이스 상속)
		SmartTv smartTv = new SmartTv();
		smartTv.process();
		
	}

}
