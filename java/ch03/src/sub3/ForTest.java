package sub3;
/*
 * 날짜 : 2025/07/08
 * 이름 : 최민수
 * 내용 : 자바 반복문 for 실습
 */

public class ForTest {
	
	public static void main(String[] args) {
		
		/*■■■■■■기본
		for(int i = 0; i < 10; i++) {
			System.out.println("i : " + i);
		}*/
		
		/*1부터 10까지 합
		int sum = 0;
		
		for(int k = 1; k <= 10; k++ ) {
			System.out.println("k : " + k);
			//sum = sum + k;
			
			sum += k;
			// A += X : X값을 A에 더하고 저장 
			// A =+ X : A에  X값을 그냥 저장
			
			System.out.println("sum : " + sum);
			
		}*/

		
		
		/*■■■■■■1부터 10까지 짝수합
		int tot = 0;
		
		for(int k=1; k<=10; k++) {
			System.out.println("k : " + k);
			if(k%2==0) {
				tot += k;
			}
		}
		System.out.println("tot : " + tot);
		*/
		
		
		/*■■■■■■for 중첩
		for(int a=1; a<=3; a++) {
			System.out.println("a: " + a);
			
			for(int b=1; b<=5; b++) {
				System.out.println("  a: " + a + " & b: " + b);
				
			}
		}*/
		
		
		/*■■■■■■구구단
		for(int x=1; x<=9; x++) {
			System.out.println(x + "단");
			
			for(int y=1; y<=9; y++) {

				//System.out.println("  " + x + " x " + y + " = " + x*y);
				
				int z = x * y;
				System.out.printf("%d x %d = %d\n", x, y, z);
				
			}
		}*/
		
		
		/*■■■■■■별삼각형*/
		for(int start = 1; start < 10; start++) {
			System.out.println("");
			
			int m = 10 - start;
			for(m = m; m >= 0; m--) {
				System.out.print(".");
				
			}
			
			for(int end = 1; end < start; end++) {

				System.out.print("★");
			}
		}
		
	}

}
