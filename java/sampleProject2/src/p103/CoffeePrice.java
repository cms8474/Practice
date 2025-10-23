package p103;

import java.util.Scanner;

public class CoffeePrice {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("무슨 커피?");
		String order = scanner.next(); //문자열 사용자 입력 받기
		int price = 0;
		switch (order) {
		
			case"에스프레소":
			case"카푸치노":
			case"카페라떼":
				price = 3500;
				break;
			case"아메리카노":
				price = 2000;
				break;
			default:
				System.out.println("없는 메뉴");
		}
		if(price != 0)
			System.out.printf("%s는 %d원입니다", order, price);
		scanner.close();
		
	} //main
}
