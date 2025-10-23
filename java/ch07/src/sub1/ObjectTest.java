package sub1;
/*
 * 날짜 250721
 * 이름 최민수
 * 내용 자바 Object클래스 실습
 */
public class ObjectTest {
	public static void main(String[] args) {
		
		Apple a1 = new Apple("한국", 3000);
		Apple a2 = new Apple("일본", 2000);
		
		
		System.out.println(a1.toString());
		System.out.println(a2);
		// toString은 기본메서드라 객체 이름 출력 가능
		
		
		// 객체비교
		if(a1 == a2) {
			System.out.println("a1 = a2");
		} else {
			System.out.println("a1 != a2");
		}
		
		
		if(a1.equals(a2)) {
			System.out.println("a1 = a2");
		}else {
			System.out.println("a1 != a2");
		}
		
		
		// 객체 해쉬값 확인
		System.out.println("a1 hash: "+a1.hashCode());
		System.out.println("a2 hash: "+a2.hashCode());
	}

}
