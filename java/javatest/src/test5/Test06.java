package test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test06 {
	public static void main(String[] args) {
		printList(createList());
	}//med
	
	public static void printList(ArrayList<Integer> scoreList) {
		int total = 0;
		int size = scoreList.size();
		
		for(int i=0 ; i<size ; i++) {
			int score = scoreList.get(i);
			total += score;
			System.out.print(score);
			
			if(i == size -1) {
				System.out.print(" = ");
			}else {
				System.out.print(" + ");
			}
		}
		System.out.println(total);
	}
	
	public static ArrayList<Integer> createList() {
		ArrayList<Integer> scoreList = new ArrayList<>();
		Random rand = new Random();
		
		for(int i=1 ; i<=10 ; i++) {
			// 60 ~ 100 사이 임의의 수
			int num = rand.nextInt(41) + 60;
			scoreList.add(num);
			}
		return scoreList;
		
	}
}//ed
