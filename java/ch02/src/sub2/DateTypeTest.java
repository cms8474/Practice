package sub2;

/*
 * 날짜: 2025/07/07
 * 이름: 최민수
 * 내용: 자바 변수 자료형 실습
 */

public class DateTypeTest {
	
	public static void main(String[] args) {
		
		//정수형
		byte  num1 = 127;
		short num2 = 32767; 
		char  num3 = 97; // 아스키 코드
		int   num4 = 2147483647;
		long  num5 = 922337203685477507L;
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3); // 아스키 코드
		System.out.println("num4 : " + num4);
		System.out.println("num5 : " + num5);
		
		//실수형
		float   n1 = 9999.123456788f; //마지막에 f 붙여야 함, 소수점 포함 총 8자리 출력, 9자리부터는 반올림
		double  n2 = 123.45678901234567;  // 소수점 17자리 출력
		
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
		
		//논리형
		boolean  t = true; // true||false
		boolean  f = false; // true||false
		
		System.out.println("t : " + t);
		System.out.println("f : " + f);
		
		//문자형
		
		System.out.println("num3 : " + num3); //96 == a(아스키 코드)
		
		num3 = '문';  
		System.out.println("num3 : " + num3);
		
		//문자열
		String  s  = "문자열";
		
		System.out.println("s : " + s);
		
		
	}

}
