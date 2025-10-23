package sub1;

public class Account {
	
	// 속성(멤버변수)
	public String bank;
	public String id;
	public String name;
	public int balance;
	
	// 기능
	public void deposit(int money) {
		this.balance += money;
	}
	public void withdraw(int money) {
		this.balance -= money;
	}
	public void show() {
		System.out.println("----------------");
		System.out.println("은행명 	: " + this.bank);
		System.out.println("계좌번호 	: " + id);
		System.out.println("입금주	: " + name);
		System.out.println("현재잔액 	: " + balance);
		System.out.println("----------------");
	}

}
