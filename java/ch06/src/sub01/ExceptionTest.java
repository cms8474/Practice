package sub01;

import java.lang.reflect.Constructor;

/*
 * 날짜 250721
 * 이름 최민수
 * 내용 자바 예외처리 실습
 */
public class ExceptionTest {
	
	public static void main(String[] args) {
		
		//실행예외(Runtime) - pg 실행 중 발생 에러
		// 예외상황 1 - n을 0으로 나눌 때
		
		
		try {
			// 예외 발생 가능성 있는 코드
			int num1 = 1;
			int num2 = 0;
			
			int r1 = num1 / num2;
			
			System.out.println("r1 : " + r1); //ArithmeticException: / by zero
			
		} catch (Exception e) {
			// 예외 발생시
			System.out.println("에러내용: "+ e.getMessage());
		}
		
		
		
		
		
		// 예외상황 2 - 배열 인덱스 참조가 잘못됐을 때 
		
		try {
			int[] arr = {1, 2, 3, 4, 5};
			for (int i=0 ; i<=arr.length ; i++) {
				// ↓ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
				System.out.println(arr[i]);  
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		// 예외상황 3 - 객체 생성없이 메서드 호출
		
		try {
			// NullPointerException: Cannot invoke "sub01.Animal.move()" 
			// ↓because "animal" is null
			Animal animal = null;
			animal.move();
		} catch (Exception e){
			e.printStackTrace();
			
		}
		
		
		
		// 예외상황 4 - 잘못된 캐스팅
		try {
			// ClassCastException: class sub01.Eagle cannot be cast to class sub01.Tiger 
		// ↓(sub01.Eagle and sub01.Tiger are in unnamed module of loader 'app')
		Animal a1 = new Tiger();
		Animal a2 = new Eagle();
		
		Tiger tiger = (Tiger)a2;//잘못된 다운 캐스팅
		}catch(Exception e) {
			e.printStackTrace();
		}
		// ------------------------------------------
		// --일반예외(Compile-time) - pg 실행 전 발생 에러---
		// ------------------------------------------
		
		// 예외상황 - 동적 객체 생성
		try {
			Class cs = Class.forName("sub1.Tiger"); // 문자열 정보로 클래스
		    Constructor<?> constructor = cs.getDeclaredConstructor();
		    Tiger tiger = (Tiger) constructor.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		
		// 예외상황 
		// 예외상황 
		
		
		System.out.println("pg end...");
	} //med
} //ted
