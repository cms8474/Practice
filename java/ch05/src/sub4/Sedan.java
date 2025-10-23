package sub4;

//자식 클래스를 만들어 부모 속성을 물려받고 자식만의 속성을 추가하자

public class Sedan extends car {

	private int cc; // 배기량(자식 속성)
	
	public Sedan(String name, String color, int speed, int cc) {
		// 부모클래스 생성자 호출(=부모 속성 상속받기)
		super(name, color, speed);
		this.cc = cc;
	
	
	} //Sedan ed
	
	public void turbo() {
		this.speed += 10;
	} //turbo ed
	
	public void show() {
		super.show();
		System.out.println("배기량 : " + this.cc);
	}
}
