package sub1;

/*
 * 날짜 : 2025/07/07
 * 이름 : 최민수
 * 내용 : 변수 실습하기 
 */

public class VariableTest {

	public static void main(String[] args) {
		
		// 변수(Variable) 초기화 된 값을 바꿀 수 있음
		int a = 3; // 변수 선언: 메모리에 공간을 확보 하는 것
		int b = 7; // 변수 초기화: 변수에 값을 최초로 저장 하는 것
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		a = 5; // 재할당
		int A = 1; // 대소문자 구분함
		System.out.println("재할당 a : " + a);
		System.out.printf("A: %d, a: %d\n", A, a); // 대소문자 구분 예시
		System.out.println("b : " + b);
		
		// 상수(Constant) 한 번 초기화 된 값으로 고정
		final int NUM = 10; // 자료형 앞에 final!!(상수 자료형 선언)
		/*NUM = 11; 상수는 초기화 이후 변경시 오류 발생*/
		
	}
}
