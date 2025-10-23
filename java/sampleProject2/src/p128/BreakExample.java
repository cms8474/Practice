package p128;

import java.util.Scanner;

import javax.swing.Spring;

public class BreakExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("exit 입력하여 종료");
		while(true) {
			System.out.print(" >> ");
			String text = sc.nextLine();
			if(text.equals("exit"))
				break;
		}
		System.out.println("종료");
	}

}
