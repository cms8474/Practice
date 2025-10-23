package test3;

public class SmartPhone extends Product{
	public SmartPhone(String productName, int price) {
		super(productName, price);
	}
	
	@Override
	public void spec() {
		System.out.println("--------------------");
		System.out.println("제품명 : " + productName);
		System.out.println("제품가격 : " + price);
	}
	

}
