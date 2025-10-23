package p122;

import java.util.Scanner;

public class WhileSample {
	public static void main(String[] args) {
		int count = 0;
		int sum   = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력하고 마지막에 -1을 입력하세요");
		
		int n = sc.nextInt();
		while(n != -1) {
			sum += n;
			count++;
			n = sc.nextInt();
		}
		if(count == 0)
			System.out.println("입력된 수가 없음");
		else {
			System.out.printf("정수의 개수는 %d개이며 ", count);
			System.out.printf("평균은 %.2f입니다\n", (double)sum/count);
			System.out.println("평균은 " + (double)sum/count + "입니다");
		}
		sc.close();
		
	}

}
