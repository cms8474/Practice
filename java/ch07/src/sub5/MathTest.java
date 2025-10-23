package sub5;
/*
 * 날짜 250722
 * 이름 최민수
 * 내용 자바 Math 클래스 실습
 */
public class MathTest {
	
	
	public static void main(String[] args) {

		
		
		System.out.println("절대값 : " + Math.abs(-5));  // 5
		System.out.println("절대값 : " + Math.abs(5));   // 5
		System.out.println("절대값 : " + Math.sqrt(9));  // 3.0
		System.out.println("절대값 : " + Math.sqrt(16)); // 4.0
		System.out.println("절대값 : " + Math.ceil(1.2)); // 2.0 (올림)
		System.out.println("절대값 : " + Math.ceil(1.8)); // 1.0 (올림)
		System.out.println("절대값 : " + Math.floor(1.2)); // 1.0(내림)
		System.out.println("절대값 : " + Math.floor(1.8)); // 1.0(내림)
		System.out.println("절대값 : " + Math.round(1.2)); // 1(반 내림)
		System.out.println("절대값 : " + Math.round(1.8)); // 2(반 올림)
		System.out.println();
		
		// 임의의 수
		double num1 = Math.random();
		System.out.println("num1 : " + num1); // 0 ~ 1 사이 실수
		
		double num2 = num1 * 10;
		System.out.println("num2 : " + num2); // 1 ~ 10 사이 실수
		
		double num3 = Math.ceil(num2);
		System.out.println("num3 : " + num3); // 1 ~ 10 사이 정수
		
		double rand = Math.ceil(Math.random()*10); // 최종합체 랜덤+10곱+올림
		System.out.println("rand : " + rand);
		
		double lott = Math.ceil(Math.random()*46); // 1~46
		System.out.println("lott : " + lott);
		System.out.println();
		
		
		
	} // med
} // ted
