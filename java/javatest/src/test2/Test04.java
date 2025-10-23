package test2;
/*
 * 날짜 20250710
 * 이름 최민수
 * 내용 자바 배열 선택정렬 연습문제
 */
public class Test04 {
	public static void main(String[] args) {
		int arr[] = {4, 2, 1, 5, 3};
		
		for (int i=0 ; i<4 ; i++) {
			for (int j=i+1 ; j<5 ; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		// 정렬된 배열 출력
		for(int n : arr) {
			System.out.print(n+" ");
		}
		
	} //main ed
} // class ed
