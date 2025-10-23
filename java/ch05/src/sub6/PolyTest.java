package sub6;

import java.security.PublicKey;

/*
 * 날짜 20250715
 * 이름 최민수
 * 내용 Java 다형성 실습
 * 
 * 다형성
 * - 상속관계에서 부모클래스의 기능이 자식클래스에서 다양한 형태로 변하는 특징
 * - (업캐스팅)객체 생성할 때 타입선언을 부모클래스 타입으로 선언
 * - 효과: 중복코드 감소, 유연성 향상
 * 
 */
public class PolyTest {
	
	public static void main(String[] args) {
		
		// 다형성 - 자식객체 타입을 부모타입으로 선언
		Animal	tiger	=	new	Tiger();  // 업캐스팅
		Animal	eagle	=	new Eagle();  // 업캐스팅
		Shark	shark	=	new Shark();  // 다운캐스팅
		
		tiger.hunt();
		eagle.hunt();
		shark.hunt();
		
		tiger.move();
		eagle.move();
		shark.move();
		
		// 다운캐스팅 - 부모타입의 객체를 자식타입으로 캐스팅(Casting, 형변환)
		Animal t = (Tiger)tiger;
		Eagle e = (Eagle)eagle;
		Shark s = (Shark)shark;
		
		t.move();
		t.hunt();
		
		// 다형성을 활용한 객체 배열
		Animal arr[] = {t, e, s};
		
		arr[0].move();
		arr[1].move();
		arr[2].move();
		
		//0716 연습
		pet dog = new Dog();
		pet cat = new Cat();
		
		dog.makeSound();
		cat.makeSound();
		
		printSound(cat);
		

		
	} //Med
	public static void printSound(pet a) {
		if(a instanceof Dog) {
			System.out.println("멍멍");
		}else {
			System.out.println("야옹");
		}
	}
	public static void printSound2(pet pet) {
		pet.makesound();
	}
	
} //Ted
