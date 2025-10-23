package sub2;
/*
 * 날짜 250721
 * 이름 최민수
 * 내용 자바 String 클래스 실습
 */
public class StringTest {
	public static void main(String[] args) {
		
		//문자열(문자+배열) 생성
		String str1 = "Hello"; // 문자열 literal(리터럴)
		String str2 = new String("Hello");
		
		System.out.println("str1 : "+ str1);
		System.out.println("str2 : "+ str2);
		
		//문자열 비교
		if(str1 == str2) {
			System.out.println("str1 == str2 : True");
		}else {
			// "=="로 비교하면 다르다!(사실상 주소값 비교)
			// "Hello"라는 값은 (배열)객체 = 힙에 저장 = 주소가 다름
			System.out.println("str1 == str2 : False");  // 출력
		}
		
		if(str1.equals(str2)) {
			// obj1.equals(obj2) 객체비교!(실질 객체값 비교)
			// ★★★반드시 문자열 비교는 equals()★★★
			System.out.println("str1.equals(str2) : True"); // 출력
		}else {
			System.out.println("str1.equals(str2) : False"); 
		}
		
		//문자열 길이
		String message = "Hello,Korea";
		System.out.println("len : "+ message.length()); // 11
		
		//문자열 추출
		char c1 = message.charAt(0);
		char c2 = message.charAt(6);
		System.out.println("c1 : "+ c1); // H
		System.out.println("c2 : "+ c2); // K
		
		//문자열 자르기
		String substr1 = message.substring(0,5);
		String substr2 = message.substring(5);
		System.out.println("substr1 : " + substr1);
		System.out.println("substr2 : " + substr2);
		
		//문자열 인덱스
		int idx1 = message.indexOf('e'); // 순차탐색
		int idx2 = message.lastIndexOf('e'); //역순탐색
		System.out.println("idx1 : " + idx1);
		System.out.println("idx2 : " + idx2);
		
		//문자열 분리
		String[] words = message.split(","); // "구분자"로 배열을 구분
		for (String word : words) {
			System.out.println(word);
		}// Hello\nKorea
		
		//문자열 교체
		String rs1 = message.replace("Korea", "Busan");
		String rs2 = message.replace("Hello", "Welcome");
		System.out.println("rs1 : " + rs1);
		System.out.println("rs2 : " + rs2);
		
		//문자열 변환
		int var1 = 1;
		double var2 = 2.1;
		boolean var3 = true;
		
		String s1 = String.valueOf(var1);
		String s2 = String.valueOf(var2);
		String s3 = ""+var3; // 편하게 이렇게 함
		
		System.out.println(s1 + "2"); // 12
		System.out.println(s2 + "1.2"); //2.11.2
		System.out.println(s3 + "false"); // truefalse
		
		
		//문자열
		
		
	} //med
}//ted
