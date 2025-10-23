package test3;

public class Car {
	private String company;
	private String name;
	private int price;
	
	public Car(String company, String name, int price) {
		this.company = company;
		this.name	 = name;
		this.price	 = price;
	}
	
	public void drive() {
	System.out.println(name+" 운행 중...");
	}
	
	public void info() {
	System.out.println("제조사 : " + company);
	System.out.println("차량명 : " + name);
	System.out.println("가 격 : " + price);
	}
}
