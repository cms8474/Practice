package sub3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 날짜 250722
 * 이름 최민수
 * 내용 자바 set 실습
 */
public class SetTest {
	
	public static void main(String[] args) {
		
		//집합 기본
		Set<Integer> set = new HashSet<Integer>();
		
		// Auto-Boxing
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(3);
		set.add(3);
		set.add(4);
		set.add(2);
		
		System.out.println(set); // 1234 중복 없음 + 자동 오름차순 정렬
		
		//반복자(Iterator)를 이용한 출력
		// set은 순서x = index x
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			// 집합에 데이터가 없을 때까지 반복
			System.out.println(it.next()); // 1234
		}
		
		for (int num : set) {
			System.out.println(num); //1234
		}
		
		/////////////////////
		//집합 연산 실습/////////
		/////////////////////
		
		Set<String> setA = new HashSet<String>(Arrays.asList("사과", "바나나", "딸기", "포도"));
		Set<String> setB = new HashSet<String>(Arrays.asList("딸기", "수박", "바나나", "오렌지"));
		
		//합집합
		Set<String> union = new HashSet<String>(setA);
		union.addAll(setB);
		System.out.println("합집합 "+union);
		
		//교집합
		Set<String> intersection = new HashSet<String>(setA);
		intersection.retainAll(setB);
		System.out.println("교집합 "+intersection);
		
		//차집합
		Set<String> minus = new HashSet<String>(setA);
		minus.removeAll(setB);
		System.out.println("A-B "+ minus);
		
		
		
	} //med
} //ed
