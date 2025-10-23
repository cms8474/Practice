package p86;

public class LogicalOperator {
	public static void main(String[] args) {
		// 비교 연산
		System.out.println('a' > 'b'); //문자끼리 비교는 거짓
		System.out.println(3 >= 2);
		System.out.println(-1 < 0);
		System.out.println(3.45 <= 2);
		System.out.println(3 == 2);
		System.out.println(3 != 2); // 3과 2는 다르니까 참
		System.out.println(!(3 != 2)); // 3과 2는 다르니까 참인데 !반전이니 거짓
		
		
		// 비교 연산과 논리 연산 복합
		System.out.println((3 > 2) && (3 > 4));
		System.out.println((3 != 2) || (-1 > 0));
		System.out.println((3 != 2) ^ (-1 > 0)); // ^ = XOR: 두 항이 다르면 참 같으면 거짓
	}

}
