package sub3;
/*
 * 날짜 250721
 * 이름 최민수
 * 내용 자바 StringBuilder 클래스 실습
 */
public class StringBuilderTest {
	public static void main(String[] args) {
		
		//String의 불변성(생성 후 값변경x = 추가적 객체생성, 주소변경x)
		String str = "Java";
		System.out.println("str주소 : "+ System.identityHashCode(str));
		
		str += "programing"; // str 주소값 변경! = 객체 변경!
		System.out.println("str주소 : "+ System.identityHashCode(str));
		
		// 빈번한 str변경을 위한 StringBuffer
		StringBuffer sb = new StringBuffer("Java");
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
		
		sb.append("Programing"); // sb 객체 값 변경o BUT 주소 변경x
		System.out.println("sb 주소 : " + System.identityHashCode(sb));
		
		//
		
		
	} //med
} //ted
