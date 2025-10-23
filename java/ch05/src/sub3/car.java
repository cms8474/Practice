package sub3;
/*
 * 날짜 20250714
 * 이름 최민수
 * 내용 Java Static 실습
 * 
 * 클래스(변수&메서드) = 정적(변수&메서드)
 * - Static으로 선언한 변수와 메서드
 * - Method Area 영역에 따로 관리
 * - new 객체 생성없이 바로 클래스 타입으로 참조
 * - 객체(인스턴스) 안에 데이터 공유 목적으로 활용
 * 
 */
public class car {
	
	// 속성(= 멤버변수, 필드)
	private String 	name;
	private String 	color;
	private int 	speed;
	
	// 전체 차량 수 저장하는 클래스 변수
	public static int count; // 클래스변수는 일반적으로 public
	
	// 생성자(Constructor) - 속성을 초기화하는 반환타입이 없고 클래스명인 메서드
	public car(String name, String color, int speed) {
		this.name 	= name;
		this.color 	= color;
		this.speed 	= speed;
		count++; // 차량 증가
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
