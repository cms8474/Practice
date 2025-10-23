package test3;


public class t3Main {
	
	public void draw(Shape obj) {
		obj.draw();
	}
	
	public static void main(String[] args) {
	
	////////
	//문제1//
	////////
	Test01	kim = new Test01("김유신", 23);
	Test01	lee = new Test01("이순신", 31);
		
		kim.show();
		lee.show();
		
	////////
	//문제2//
	////////
	King k1 = new King("태조", 1392);
	King k2 = new King("세종대왕");
	King k3 = new King(1776);
	
	k1.show();
	k2.show();
	k3.show();
	
		
	////////
	//문제3//
	////////
	Car sonata = null;
	Car k5 = null;
	
	sonata = new Car("현대","소나타",3000);
	k5 	   = new Car("기아","K5",4000);
	
	sonata.drive();
	sonata.info();
	k5.drive();
	k5.info();
	
	////////
	//문제4//
	////////
	Student.studentId = 20201000;
	
	Student kim1 = new Student("김유신", "국문과", 1);
	kim1.studentInfo();
	
	Student lee2 = new Student("이순신", "경제학과", 1);
	lee2.studentInfo();
	
	Student lim = new Student("임꺽정", "경영학과", 1);
	lim.studentInfo();
	
	
	////////
	//문제5//
	////////
	CarFactory factory = CarFactory.getInstance();
	
	Vehicle avante = factory.createCar("아반테", 2500);
	Vehicle sonata2 = factory.createCar("소나타", 3000);
	
	avante.info();
	sonata2.info();
	
	
	////////
	//문제6//
	////////
	Adder a1 = Adder.getInstance();
	
	a1.add(1, 2);
	a1.show();
	
	int[] arr = {10, 20};
	a1.add(arr);
	a1.show();
	
	Adder.add(a1);
	a1.show();
	
	a1 = Adder.add(a1, 3);
	a1.show();
	
	////////
	//문제7//
	////////
	Customer kim7 = new Customer(1001, "김춘추");
	VipCustomer lee7 = new VipCustomer(1002, "이순신");
	
	System.out.println("김춘추 지불할 금액 : "+kim7.calcPrice(10000));
	System.out.println("이순신 지불할 금액 : "+lee7.calcPrice(10000));
	
	kim7.showInfo();
	lee7.showInfo();
	
	////////
	//문제8//
	////////
	Product p1 = new SmartPhone("갤럭시", 100);
	Product p2 = new Computer("맥북프로", 200);
	
	p1.spec();
	p2.spec();
	
	////////
	//문제9//
	////////
	t3Main here = new t3Main();
	
	Circle circle = new Circle();
	Triangle triangle = new Triangle();
	
	here.draw(circle);
	here.draw(triangle);
	
	////////
	//문제10//
	////////
	Buyer buyer =  new Customers();
	Seller seller = new Customers(); 
	
	buyer.buy();
	seller.sell();
	
	}//Med
}//Ted
