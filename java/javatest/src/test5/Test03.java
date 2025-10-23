package test5;

import java.util.Scanner;

class LoginException extends Exception{
	public LoginException(String msg) {
		super(msg);
	}
}


public class Test03 {
	public static void main(String[] args) {
		
		String userId = "a101";
		String userPw = "abc1234";
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("아이디: ");
			String inputId = sc.nextLine();
			
			System.out.print("비밀번호: ");
			String inputPw = sc.nextLine();
			
			if(!inputId.equals(userId)) {
				throw new LoginException("아이디 트림");
			}else if(!inputPw.equals(userPw)) {
				throw new LoginException("비밀번호 트림");
			}else {
				System.out.println("로그인!");
			}
			
		}catch(LoginException e) {
			System.out.println(e.getMessage());
		}
		
	}//med
}//ed
