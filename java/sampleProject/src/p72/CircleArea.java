package p72;

public class CircleArea {
	public static void main(String[] args) {
		final double PI = 3.14;
		
		double radius = 10.0; // 원의 반지름
		double circleArea = radius*radius*PI; //원 면적 계산
		
		//원 면적 화면 출력
		System.out.println("원의 면적 : " + circleArea);
	}

}
