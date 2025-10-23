package sub7;
/*
 * 날짜 20250716
 * 이름 최민수
 * 내용 자바 추상 클래스 실습
 */
public class AbstractTest {
	
	public static void main(String[] args) {
		
		// 추상 클래스는 객체 단독 생성 불가
		//Animal animal = new Animal();
		
		Animal tiger = new Tiger();
		Animal eagle = new Eagle();
		
		tiger.move();
		tiger.hunt();
		
		eagle.move();
		eagle.hunt();

	}

}
