package sub1;
/*
 * 날짜 250722
 * 이름 최민수
 * 내용 자바 generic 실습
 */
public class GenericTest {
	
	public static void main(String[] args) {
		
		Apple apple = new Apple("한국", 3000);
		Banana banana = new Banana("대만", 2000);
		
		//치환변수 T를 Apple로 치환
		FruitBox<Apple> box1 = new FruitBox();
		box1.setFruit(apple);
		
		FruitBox<Banana> box2 = new FruitBox<Banana>();
		box2.setFruit(banana);
		
		System.out.println(box1.getFruit());
		System.out.println(box2.getFruit());
		
	} //med
} //ed
