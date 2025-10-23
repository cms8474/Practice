package test5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test07 {
	public static void main(String[] args) {
		for(int count=1 ; count <=5 ; count++) {
			System.out.println(makeLotto());
		}
	}//med
	
	public static Set<Integer> makeLotto() {
		Set<Integer> lottoSet = new HashSet<>();
		
		for(;;) {
			int num = (int) Math.ceil(Math.random() * 44)+1;
			lottoSet.add(num);
			
			if(lottoSet.size() == 6) {
				break;
			}
		}//fed
		
		
		// 정렬을 위한 TreeSet
		Set<Integer> treeSet = new TreeSet<>(lottoSet);
		
		return treeSet;
	}
	
	
}//ed
