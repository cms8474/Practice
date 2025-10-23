package test3;
	

	
public class VipCustomer extends Customer {
	
	private double saleRatio;
	
	public VipCustomer(int id, String name) {
		super(id, name);
		super.grade = "VIP";
		super.point = 1000;
		super.pointRatio = 0.05;
		this.saleRatio = 0.1;
	}
		
	@Override
	public int calcPrice(int price) {
		point += price * pointRatio;
		return price - (int)(price * saleRatio);
	}
	
}
