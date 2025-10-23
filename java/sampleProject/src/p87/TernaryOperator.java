package p87;

public class TernaryOperator {
	public static void main(String[] args) {
		int a=3, b=5;
		
		System.out.println("두 수의 차는 " + ((a>b)?(a-b):(b-a)));
		//a와 b의 크기를 비교하여 참이면 앞, 거짓이면 뒤항을 계산한 값을 출력
	}

}
