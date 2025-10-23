package test7.sub2;

public class Product {
	private String 	prodId;
	private String	prodName;
	private int 	price;
	private int		quantity;
	
	public Product(String prodId, String prodName, int price, int quantity) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
		this.quantity = quantity;
	}


	public void printProductInfo() {
		System.out.printf("상품코드 : %s\n상품이름 : %s\n상품가격 : %d\n재고수량 : %d\n", prodId, prodName, price, quantity);
	} 
}
