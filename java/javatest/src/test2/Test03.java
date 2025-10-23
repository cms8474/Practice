package test2;
/*
 * 날짜 20250710
 * 이름 최민수
 * 내용 자바 배열 역순 정렬 연습문제
 */
public class Test03 {
	public static void main(String[] args) {
		int arr[] = new int[10];
		for (int i=0 ; i<arr.length ; i++) {
			arr[i] = i+1;
		}
		
		// 현재 배열 출력
		for (int i : arr) {
			System.out.print(i +" ");
		}
		System.out.println();
		
		// 배열의 원소를 역순으로 정렬
		for (int j=0 ; j<5 ; j++) {
			int temp = arr[j];
			arr[j] = arr[9-j];
			arr[9-j] = temp;
			
		}
		
		// 역순으로 정렬된 배열 출력
		for (int n : arr) {
			System.out.print(n+", ");
		}
	} //main ed
} // class ed
