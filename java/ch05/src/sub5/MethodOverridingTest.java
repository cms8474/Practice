package sub5;
/*
 * 날짜 20250715
 * 이름 최민수
 * 내용 Java 오버라이드 실습
 */

class	AAA	{
	public void method1() {
		System.out.println("AAA:method1...");
	}
	public void method2() {
		System.out.println("AAA:method2...");
	}
	public void method3() {
		System.out.println("AAA:method3...");
	}
} // AAA ed

class	BBB	extends AAA {
	@Override
	public void method2() { // AAA.method2를 Override
		System.out.println("BBB:method2...");
	}
	public void method3(int a) { //Overload 메서드
		System.out.println("BBB:method3...");
	}
} // BBB ed

class	CCC	extends BBB {
	@Override
	public void method1() { // AAA.method1을 override
		System.out.println("CCC:method1...");
	}
	@Override
	public void method2() {// AAA.method2을 override
		System.out.println("CCC:method2...");
	}
	public void method3(int a, int b) { //Overload 메서드
		System.out.println("CCC:method3...");
	}	
} // CCC ed


public class MethodOverridingTest {
	
	public static void main(String[] args) {
		
		//오버라이드 실습 1
		CCC c	=	new CCC();
		c.method1();
		c.method2();
		c.method3();
		c.method3(1);
		c.method3(1,2);
		
		//오버라이드 실습 2_Sedan speedUP
		Sedan sonata = new Sedan("소나타", "흰색", 0, 2000);
		sonata.speedUp(200);
		sonata.show();
		
		
	} // main ed
} // Big ed
