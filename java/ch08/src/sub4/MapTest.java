package sub4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * 날짜 250722
 * 이름 최민수
 * 내용 자바 map 실습
 */
public class MapTest {
	public static void main(String[] args) {
		
		// map 생성
		Map<Character, String> map = new HashMap();
		
		// map 데이터 추가 __Charcter는 ''로 감쌈. ""와 혼용 금지
		map.put('A', "Apple");
		map.put('B', "Banana");
		map.put('C', "Cherry");
		
		System.out.println(map);
		
		// map 크기
		System.out.println("map size " + map.size());
		
		// map 데이터 출력
		System.out.println("Map.A : " + map.get('A'));
		System.out.println("Map.B : " + map.get('B'));
		System.out.println("Map.C : " + map.get('C'));
		
		// map 반복문 .. INDEX가 없어서 반복자 필요(LIKE SET)
		Set<Character> keySet = map.keySet(); //set구조에 map의 키만 넣기
		Iterator<Character> it =  keySet.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for(char key : map.keySet()) {
			System.out.println(map.get(key));
		}
		
		System.out.println("----------------------");
		// map과 List 응용
		Map<Integer, Apple> m1 = new HashMap();
		m1.put(101, new Apple("한국", 3000));
		m1.put(102, new Apple("중국", 2000));
		m1.put(103, new Apple("일본", 1000));
		
		Map<Integer, Apple> m2 = new HashMap();
		m2.put(201, new Apple("미국", 3000));
		m2.put(202, new Apple("영국", 2000));
		m2.put(203, new Apple("호주", 1000));
		
		Map<Integer, Apple> m3 = new HashMap();
		m3.put(301, new Apple("대만", 3000));
		m3.put(302, new Apple("태국", 2000));
		m3.put(303, new Apple("인도", 1000));
		
		List<Map<Integer, Apple>> list = new ArrayList();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		// 한국사과출력
		Map<Integer, Apple> resultMap = list.get(0);
		Apple koreApple = resultMap.get(101);
		koreApple.show();
		
		// 호주사과 출력
		list.get(1).get(203).show();
		
		// 태국사과
		list.get(2).get(302).show();
		 
		
		
	} //med
} //ed
