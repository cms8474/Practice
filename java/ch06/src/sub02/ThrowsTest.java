package sub02;

import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 날짜 250721
 * 이름 최민수
 * 내용 자바 예외던지기 실습
 */
public class ThrowsTest {
	public static void main(String[] args) {
		
		try {
			method1(7);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("pg end");
		
	} //med
	
	public static void method1(int n) throws Exception {
		method2(n);
	}
	
	public static void method2(int n) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("값 입력: ");
		int value = scanner.nextInt(); // InputMissmatchException 발생
		
		int result = n / value; // ArtithmeticException 발생
		
		System.out.println("result : " + result);
	}
	
	
} //ted
