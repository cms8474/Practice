package test2;
/*
 * 날짜 20250710
 * 이름 최민수
 * 내용 자바 피보나치 수열 재귀 메서드 연습문제
 * 피보나치 수열: f(n) = f(n-1) + f(n-2)
 */
public class Test10 {
	public static void main(String[] args) {
		
		for(int i=0 ; i<10 ; i++) {
			System.out.print(fibo(i)+" ");
		}
	}//main ed
	
	public static int fibo(int n) {
		
		if(n <= 1) {
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
} // class ed
