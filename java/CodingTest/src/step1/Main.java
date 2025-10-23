package step1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[N]; // 비교대상 진
		String[] tempArr = sc.nextLine().split(" "); // 비교대상
		
		for(int i=0 ; i<tempArr.length ; i++) {
			arr[i] = Integer.parseInt(tempArr[i]);
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int j=1 ; j<arr.length ; j++) {
			min = Math.min(min, arr[j]);
			max = Math.max(max, arr[j]);
		}
		
		System.out.println(min+ " " + max);
	} 	// main ed
} 		// class ed 
