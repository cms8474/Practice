package step1;
/*
 *\    /\
 *)  ( ')
 *(  /  )
 *\(__)|
 */

// 클래스 명 바꿔라아아아아아아
public class Main2 {
	
	public static void main(String[] args) {
		
		int a = 1; // 현재 시_24가 되면 0이 된다!
		int b = 10; // 현재 분
		int c = 161; // 가중 분
		int add		= ((b+c)/60);
				
				
		int resultA = (a+add)%24;
		//int resultB = ((b+c)/60)+((b+c)%60); // 결과 분_60초과 = 시침 + 1
		int resultB = (b+c)%60; // 결과 분_60초과 = 시침 + 1
		
		if(resultA>=24) {
			System.out.printf("%d %d",resultA-24,resultB);
		}else {
			System.out.printf("%d %d",resultA,resultB);
		}
		
	}
}
