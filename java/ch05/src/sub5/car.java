package sub5;

public class car {
	
	// 속성(= 멤버변수, 필드)
	// 속성은 일반적으로 pri. 부모클래스이면 protected
	protected String 	name; //protected: 자식에게만 접근 허용
	protected String 	color;
	protected int 		speed;
	
	// 생성자(Constructor) - 속성을 초기화하는 반환타입이 없고 클래스명인 메서드
	public car(String name, String color, int speed) {
		this.name 	= name;
		this.color 	= color;
		this.speed 	= speed;
	}
	
	// 기능(=멤버메서드)
	// static 안씀 공개범위, 반환값, 함수명 사용
	public void speedUp(int speed) {
		//자기참조 this를 붙여서 외부값이 아닌 클래스 내부의 멤버변수를 지칭
		this.speed += speed; 
	}
	
	public void speedDown(int speed) {
		this.speed -= speed;
		
	}
	
	public void show() {
		System.out.println("차량명 : "+ this.name);
		System.out.println("차량색 : "+ color);  //this 생략 가능
		System.out.println("현재속도 : "+ speed); //this 생략 가능
		
	}
	
	// Getter/Setter - 은닉된 속성을 안전하게 처리하기 위한 메서드
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
