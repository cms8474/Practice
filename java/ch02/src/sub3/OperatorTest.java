package sub3;
/*
 * 날짜: 2025/07/07
 * 이름: 최민수
 * 내용: 연산자 테스트 
 */

public class OperatorTest {
	
	public static void main(String[] args) {
		
		// 산술
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		int num4 = 4;

		int result1 = num1 + num2;
		int result2 = num1 - num2;
		int result3 = num1 * num2;
		int result4 = num1 / num2;
		int result5 = num3 % num2;
		
		System.out.println("num1 + num2 = : " + result1);
		System.out.println("num1 - num2 = : " + result2);
		System.out.println("num1 * num2 = : " + result3);
		System.out.println("num1 / num2 = : " + result4);
		System.out.println("num1 % num2 = : " + result5);
		
		// 증감
		int num = 0;
		System.out.println("num = " + num);
		
		num++;
		System.out.println("num++ = " + num);
		
		++num; //연산자 앞 뒤 위치는 처리 순서를 결정
		System.out.println("++num = " + num);
		
		num--;
		System.out.println("num-- = " + num);

		--num;
		System.out.println("--num = " + num);
		
		/*이건 안 됨 ㅋ
		--num--;
		System.out.println("--num-- = " + num);*/
		
		
		// 복합대입
		int n1 = 1, n2 = 2, n3 = 3, n4 = 4;
		System.out.println("n1,n2,n3,n4 = " + n1 + "," + n2 + "," + n3 + "," + n4);
		
		// 왼쪽 변수 값과 오른쪽 값을 연산자로 계산한 값으로 대입해라
		n1 += 1; // n1 = n1 + 1
		n2 -= 2;
		n3 *= 3;
		n4 /= 4;
		System.out.println("n1,n2,n3,n4 = " + n1 + "," + n2 + "," + n3 + "," + n4);
		
		// 비교(관계)
		int val1 = 1;
		int val2 = 2;
		
		boolean rs1 = val1 > val2; //var1이 var2보다 크다 = 거짓
		boolean rs2 = val1 < val2; //var1이 var2보다 크다 = 참
		boolean rs3 = val1 >= val2; //var1이 var2보다 크거나 같다 = 거짓
		boolean rs4 = val1 <= val2; //var1이 var2보다 작거나 같다 = 참
		boolean rs5 = val1 == val2; //var1과 var2는 서로 같다 = 거짓
		boolean rs6 = val1 != val2; //var1과 var2는 서로 다르다 = 참
		
		System.out.println("rs1 : " + rs1);
		System.out.println("rs2 : " + rs2);
		System.out.println("rs3 : " + rs3);
		System.out.println("rs4 : " + rs4);
		System.out.println("rs5 : " + rs5);
		System.out.println("rs6 : " + rs6);
		
		// 논리
		int val3 = 3;
		int val4 = 4;

		boolean res1 = (val3 > 3) && (val4 > 3);
		System.out.println("(val3 > 3) && (val4 > 3) : " + res1); 
		// AND && 1개만 맞음 = 거짓
		
		boolean res2 = (val3 > 2) && (val4 > 3);
		System.out.println("(val3 > 2) && (val4 > 3) : " + res2);
		// AND && 2개 모두 맞음 = 참

		boolean res3 = (val3 > 3) || (val4 > 3);
		System.out.println("(val3 > 3) || (val4 > 3) : " + res3);
		// OR || 2개 중 하나라도 맞음 = 참

		boolean res4 = (val3 > 3) || (val4 > 4);
		System.out.println("(val3 > 4) || (val4 > 5) : " + res4); 
		// OR || 2개 모두 틀림 = 거짓
		
		boolean res5 = !(val3 < 4);
		System.out.println("!(val3 < 4) : " + res5); 
		// NOT ! 참거짓 반전!! 참 => 거짓 // 거짓 => 참

	}

}