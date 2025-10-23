package test3;

public class Computer extends Product{

	public Computer(String productName, int price) {
		super(productName, price);
	}
	
	public void spec() {
		System.out.println("--------------------");
		System.out.println("제품명 : " + productName);
		System.out.println("제품가격 : " + price);
	}
}
