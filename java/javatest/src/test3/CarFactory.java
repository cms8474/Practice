package test3;

public class CarFactory {
	private static CarFactory instance = new CarFactory();
	private CarFactory() {}
	
	public static CarFactory getInstance() {
		return instance;
	}
	public Vehicle createCar(String name, int price) {
		return new Vehicle(name, price);
	}

}
