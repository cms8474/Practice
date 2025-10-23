package sub4;
/*
 * 날짜 : 2025/07/08
 * 이름 : 최민수
 * 내용 : 반복문 while 실습
 */

public class WhileTest {
	
	public static void main(String[] args) {
		
		// 1 ~ 10 합
		/*초기식 입력*/
		int sum = 0;
		int k = 1;
		
		/*기본 while*/
		while(k <= 10) {
			
			sum += k;
			k++;
		}
		System.out.println("1부터 10까지의 합: " + sum);
		
		
		/* do ~ while 최초 1회 실행 후 조건문을 보고 do{}반복실행*/
		int tot = 0;
		int j = 1;
		
		do {
			
			if(j%2 == 0) {
				tot += j;
			}
			
			j++;
			
			
		}while(j <= 10);
		
		System.out.println("1부터 10까지 짝수합: " + tot);
		
		
		/* break*/
		int num = 1;
		
		while(true) {
			
			
			//5, 7의 최소공배수 구하기(35)
			if(num % 5 == 0 && num % 7 == 0) {
				break; // 반복문 탈출(종료)
			}
			
			num++;
			
		}
		
		System.out.println("5와 7의 최소공배수: " + num);
		
		
		/* continue*/
		int total = 0;
		int i = 1;
		
		while(i <= 10) {
			
			i++;
			
			if(i % 2 == 1) {
				continue; // 반복문 상위 이동(조건으로 올라가)
			}
			
			total += i;
		}
		
		System.out.println("1부터 10까지의 짝수합: " + total);
		
	}

}
