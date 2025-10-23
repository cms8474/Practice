package p84;

public class AssignmentlncDecperator {
	public static void main(String[] args) {
		int a=3, b=3, c=3;
		//대입 연산자 사례
		a += 3; //a=a+3 = 6
		b *= 3; //b=b*3 = 9
		c %= 2; //c=c%2 = 1
		System.out.println("a=" + a + ", b=" + b + ", c=" + c);
		
		int d=3;
		//증감 연산자 사례
		a = d++; // a=3, d=4 // b+1값을 a에 저장
		System.out.println("a=" + a + ", d=" + d);
		a = ++d; // d=5, a=5 // d에 1을 더한 값을 저장하고 그 값을 a에 저장
		System.out.println("a=" + a + ", d=" + d);
		a = d--; // a=5, d=4
		System.out.println("a=" + a + ", d=" + d);
		a = --d; // d=3, a=3
		System.out.println("a=" + a + ", d=" + d);
	}

}
