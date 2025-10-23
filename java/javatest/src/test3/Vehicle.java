package test3;

public class Vehicle {
	private String name;
	private int price;
	
	public Vehicle(String name, int price) {
		this.name = name;
		this.price = price;
	}
	public void info() {
		System.out.println("--------------");
		System.out.println("차량명 : " + name);
		System.out.println("가 격 : " + price );
	}

}
