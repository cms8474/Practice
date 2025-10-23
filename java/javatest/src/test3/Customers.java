package test3;

interface Buyer {
	public void buy();
}

interface Seller {
	public void sell();
}

public class Customers implements Buyer, Seller {

	@Override
	public void sell() {
		System.out.println("판매하기");
	}
	@Override
	public void buy() {
		System.out.println("구매하기");
	}

}
