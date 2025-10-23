package sub2;

import java.util.Scanner;

/*
 * 날짜 : 2025/07/08
 * 이름 : 최민수
 * 내용 : 자바 스위치 조건문 실습
 */
public class switchTest {
	
	public static void main(String[] args) {
		
		System.out.print("숫자 입력 : ");
		
		/* 사용자 입력
		 스캐너타입 sc(객체, 참조변수) = 생성 사용자입력(프로그램 시스템에 입력된)
		 sc라는 이름의 사용자입력을 받아들이는 변수를 생성, 사용자 입력 대기*/
		Scanner sc = new Scanner(System.in);
		
		// int타입 num~는 sc가 받아들인 사용자 입력의 값으로 초기화
		int number = sc.nextInt(); // 숫자 입력
		
		// number = sc(사용자입력값) 출력
		System.out.println("입력한 숫자 : " + number);
		
		
		
		
		// 조건문 시작
		switch(number % 2) {
		
		// 조건문의 실행 결과에 따라 진행
		case 0:
			System.out.println("짝수");
			break; // 탈출 메서드 필수, 없으면 다음 행으로 넘어가서 실행됨
			
		case 1:
			System.out.println("홀수");
			break;
			
		}
		
	
		
		
		
		
	}

}
