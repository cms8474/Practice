package sub8;

public class RemoteSamsung implements RemoteControl {//인터페이스 상속
	String a = "Samsung";
			
	@Override
	public void powerOn() {
		System.out.println(a +" powerOn");
	}

	@Override
	public void powerOff() {
		System.out.println(a +" powerOff");
	}

	@Override
	public void chUp() {
		System.out.println(a +" chUp");
	}

	@Override
	public void chDown() {
		System.out.println(a +" chDown");
	}

	@Override
	public void sonudUp() {
		System.out.println(a +" sonudUp");
	}

	@Override
	public void soundDown() {
		System.out.println(a +" soundDown");
	} 
}
