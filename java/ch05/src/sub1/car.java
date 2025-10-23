package sub1;
/*
 * 날짜 20250714
 * 이름 최민수
 * 내용 자바 클래스 실습
 *     클래스 설계(정의)
 */
public class car {
	
	// 속성(= 멤버변수, 필드)
	String 	name;
	String 	color;
	int 	speed;
	
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
	

}
