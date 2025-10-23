package ex;

public class car {
	
	// 속성(= 멤버변수, 필드)
	private String 	name;
	private String 	color;
	private int 	speed;
	
	// 클래스 변수:전체 차량 수 
	public static int count; // 클래스변수는 일반적으로 public
	
	// 생성자(Constructor)
	public car(String name, String color, int speed) {
		this.name 	= name;
		this.color 	= color;
		this.speed 	= speed;
		count++; // 차량 증가
	}
	
	// 기능(=멤버메서드)
	public void speedUp(int speed) {
		this.speed += speed; 
	}
	
	public void show() {
		System.out.println("차량명 : "+ this.name);
		System.out.println("차량색 : "+ color);  //this 생략 가능
		System.out.println("현재속도 : "+ speed); //this 생략 가능
	}
	
	// Getter/Setter - 은닉된 속성을 안전하게 처리하기 위한 메서드
	public void setColor(String color) {
		this.color = color;
	}
	
}
