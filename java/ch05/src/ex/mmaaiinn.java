package ex;

import sub3.Calc;

public class mmaaiinn {
	public static void main(String[] args) {
		
		car sonata = new car("소나타", "흰색", 0);
		
		sonata.speedUp(80);
		sonata.setColor("남색");
		sonata.show();
		System.out.println("ToT car : " + car.count); // = 1
		
		//////////
		///싱글톤///
		//////////
		
		Calc c1 = Calc.getInstance();
		
		System.out.println("1+2= " + c1.plus(1, 2));
	}

}
