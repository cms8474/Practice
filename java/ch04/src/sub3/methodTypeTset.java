package sub3;
/*
 * 날짜 : 2025/07/09
 * 이름 : 최민수
 * 내용 : 자바 메서드 타입 실습
 */
public class methodTypeTset {
	public static void main(String[] args) {
		
		double y1 = type1(2.5);
		double y2 = type1(3.2);
		double y3 = type1(4.0);
		
		System.out.println("y1: "+y1);
		System.out.println("y2: "+y2);
		System.out.println("y3: "+y3);
		
		// 반환값 없음. 함수 호출 앞 대입연산자 없음
		type2(true);
		type2(false);
		type2(2>3);
		
		boolean result = type3();
		System.out.println("result: "+ result);
		
		type4();
		
	} //main end
	
	// type1 : 매개변수o, 반환값o
	public static double type1(double r) {
		double y = r * r + Math.PI; // Math클래스로 파이 불러오기
		return y;
	}
	
	// type2 : 매개변수o, 반환값x
	public static void type2(boolean status) {
		if(status) {
			System.out.println("참참");
		}else {
			System.out.println("놉놉");
		}
	}
	
	
	// type3 : 매개변수x, 반환값o
	public static boolean type3() { // 매개변수가 없으니 () <- 공백
		int num1 = 1;
		int num2 = 2;
		if(num1 > num2) {
			return true;
		} else {
			return false;
		}
	}
	
	// type4 : 매개변수x, 반환값x
	public static void type4() {
		double result = type1(5.0);
		System.out.println("지름 5 반지름 넓이:" + result);
	}
	
} //class end
