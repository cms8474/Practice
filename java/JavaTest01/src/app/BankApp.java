package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
	private	List<Account>	accounts = new ArrayList<>();
	private Scanner 		scanner  = new Scanner(System.in);
	
	public static void main(String[] args) {
		BankApp app = new BankApp();
		app.start();
		
		System.out.println("프로그램 종료");
		
	} //med
		
	public void start() {
		boolean running = true;
		
		while (running) {
			printMenu();
			System.out.print("선택> ");
			int choice = Integer.parseInt(scanner.nextLine());
			
			switch(choice) {
			case 1 -> createAccount();
			case 2 -> listAccounts();
			case 3 -> depositAccount();
			case 4 -> withdrawAccount();
			case 5 -> {
				running = false;
			}
			default -> System.out.println("올바른 번호를 선택하세요.");
			}
		}
	}
	
	public void printMenu() {
		System.out.println("--------------------------------------------------");
		System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
		System.out.println("--------------------------------------------------");
	}
	
	// 메서드로 프로그램 완성하기
	public void createAccount() {
		String ano		= scanner.nextLine();
		String owner	= scanner.nextLine();
		int balance 	= Integer.parseInt(scanner.nextLine());
		Account account = new Account(ano, owner, balance);
		accounts.add(account);
		
		System.out.println("계좌번호: " 	+ account.getAno());
		System.out.println("계좌주: " 	+ account.getOwner());
		System.out.println("초기입금액: " 	+ account.getBalance());
		System.out.println("계좌가 생성되었습니다.");
	}
	public void listAccounts() {
		for(int i=0 ; i<accounts.size() ; i++) {
			Account j = accounts.get(i);
			System.out.print(j.getAno()+" ");
			System.out.print(j.getOwner()+" ");
			System.out.print(j.getBalance()+"\n");
		}
	}
	
	public void depositAccount() {
		System.out.print("계좌번호: ");
		String	ano = scanner.nextLine();
		System.out.print("예금액: ");
		int		balance = Integer.parseInt(scanner.nextLine());
		try {
			Account j = findAccount(ano);
			int myB = j.getBalance();
			j.setBalance(myB + balance);
			System.out.println("결과: 예금이 성공되었습니다.");
		} catch (Exception e) {
			System.out.println("결과: 계좌가 없습니다.");
		}
	}
		
	public void withdrawAccount() {
		System.out.print("계좌번호: ");
		String	ano = scanner.nextLine();
		System.out.print("예금액: ");
		int		balance = Integer.parseInt(scanner.nextLine());
		try {
			Account j = findAccount(ano);
			int myB = j.getBalance();
			j.setBalance(myB - balance);
			System.out.println("결과: 출금이 성공되었습니다.");
		} catch (Exception e) {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		}
	}
	
	public Account findAccount(String ano) {
		for (int i=0 ; i<accounts.size() ; i++) {
			Account j = accounts.get(i);
			if(ano.equals(j.getAno())) {
				return j;
			}else {
				continue;
			}
		}
		return null;
	}
}

