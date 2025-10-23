package p283.supsub;

class Supers {
	private String mono = "SUPER's MONO";
	public void sysout1() {
		System.out.print("Super1 ");
		System.out.println(mono);
	}
}

class Sub extends Supers {
	private String mono = "sub's mono";
	public void sysout1() {
		System.out.print("Sub1 ");
		System.out.println(mono);
	}
	public void sysout2() {
		System.out.print("Sub2 ");
		System.out.println(mono);
	}
}

public class SupSub {
	public static void print(Supers s) {
		if(s instanceof Supers) {System.out.println("my type is Supers");}
		if(s instanceof Sub) {System.out.println("my type is Sub");}
	}
	
	public static void main(String[] args) {
		System.out.println("----print(super1)----");
		Supers super1 = new Supers();
		print(super1);
		System.out.println("\n----print(sub)----");
		Sub sub		  = new Sub();
		print(sub);
		System.out.println("\n----cannot: Sub sub2 = (Sub) new Supers();----");
		// Sub sub2	=	(Sub) new Supers(); 부모의 생성자를 강제로 자식으로 만들 순 없음
		
		// 일반적인 생성 후 호출
		System.out.println("\n----super1.sys1----");		
		super1.sysout1();
		System.out.println("----sub.sysout1----");			
		sub.sysout1();
		System.out.println("----sub.sysout2----");			
		sub.sysout2();
		
		
		
		// 업캐스팅_수퍼1은 섭을 가리킨다 = 섭이 수퍼1에 업캐스팅 됐다.
		// 업캐스팅은 (super1)sub에서 (super1)을 생략 할 수 있다
		System.out.println("\n---- super1 = sub 업캐스팅----");
		System.out.println("---- super1.sysout1 & 2----");
		super1 = sub;				
		super1.sysout1(); // 메서드는 참조변수 실제타입(sup은 서브클래스가 실제). 필드는 참조변수 선언타입에 따라 접근.
		print(super1);
		System.out.println("super1.sysout2() 불가(=자식 고유 필드, 메서드)"); // 자식만 있는 메서드는 사용 불가
		
		
		// 다운캐스팅_자기자신을 다운캐스팅
		System.out.println("\n---- super1 = (Sub)super1 다운캐스팅----");
		System.out.println("---- super1.sysout1 & 2----");
		super1 = (Sub)super1;	
		super1.sysout1();
		System.out.println("super1.sysout2() 불가(=자식 고유 필드, 메서드)");

		
		
		System.out.println("\n---- (자식)sub = (부모)super1; 업캐스팅----");
		System.out.println("sub = (Supers)super1; --- 불가");
		
		// 다운캐스팅_섭은 (자식)수퍼1을 가리킨다 = (자식)수퍼1이 섭에 다운캐스팅 됐다
		// 다운캐스팅은 (Sub)생략 불가. 안적으면 오류.
		System.out.println("\n---- sub = (Sub)super1 다운캐스팅----");
		System.out.println("---- sub.sysout1----");
		sub = (Sub)super1;			
		sub.sysout1();
		System.out.println("---- sub.sysout2----");		
		sub.sysout2();
		
		


		
	}

}
