package sub3;
/*
 * 날짜 20250714
 * 이름 최민수
 * 내용 Java Static (클래스)변수, Static (클래스)메서드 실습
 */

class Increment {
	private int num1=0;
	public static int num2=0;
	
	public Increment() {
		num1++;
		num2++;
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
}

public class StaticTest {
	public static void main(String[] args) {
		
		// 클래스 변수(정적변수) 실습
		Increment inc1 = new Increment();// 출력 1, 1
		Increment inc2 = new Increment();// 출력 1, 2
		Increment inc3 = new Increment();// 출력 1, 3 ->메서드 영역의 클래스 변수는 공유됨
		
		// 차량 수
		car sona = new car("sona", "Br", 0);
		car avan = new car("avan", "Wh", 0);
		car gran = new car("gran", "Wh", 0);
		
		sona.show();
		avan.show();
		gran.show();
		
		System.out.println("전체 차량 수 : " + car.count); // 출력 3
		
		//////////////////////////////////////
		//싱글톤
		//////////////////////////////////////
		//- 싱글톤 객체는 static을 활용한 객체 
		//-오직 하나의 인스턴스만 메모리(m-a)에 존재
		//- 싱글톤을 활용해 메모리 절약, 성능 향상 기대
		//- 외부 생성을 막기 위해 pri생성자 선언
		//////////////////////////////////////
		
		/* 여러개 객체를 생성 할 필요가 없는 객체
		Calc cal = new Calc();
		int result = cal.plus(1, 2);
		System.out.println("result : " + result);
		*/
		
		Calc c1 = Calc.getInstance();
		Calc c2 = Calc.getInstance();
		Calc c3 = Calc.getInstance();
		Calc c4 = Calc.getInstance();
		
		System.out.println("1 + 2 : " + c1.plus(1, 2));
		System.out.println("1 - 2 : " + c2.minus(1, 2));
		System.out.println("3 * 2 : " + c3.multi(2, 3));
		System.out.println("4 / 2 : " + c4.div(4, 2));
		
	} //main ed
} // class ed
