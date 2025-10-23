package test7.sub5;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int 			orderNo;
	private Customer		customer;
	private List<Product>	products;
	private int				totalPrice;
	public Order(int orderNo, Customer customer) {
		super();
		this.orderNo	= orderNo;
		this.customer	= customer;
		products		= new ArrayList<Product>();
		totalPrice		= 0;
	}
	
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	public int getOrderNo() {
		return orderNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
	
	

}
