package sub3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * date 25 0724
 * name minsu choi
 * text java FileterStream practice
 */

public class FileterStreamTest {
	public static void main(String[] args) {
		//list 생성
		List<Integer> numbers = Arrays.asList(1,2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3);
		System.out.println(numbers);
		
		//중복제거 출력
		numbers.stream().distinct().forEach(num -> System.out.println(num + ", "));
		List<Integer> newNumbers = numbers.stream().distinct().collect(Collectors.toList());
		System.out.println(newNumbers);
		
		// 3 이상 필터링
		List<Integer> numbers3 =  numbers
										.stream()
										.distinct()
										.filter(num ->{
											if(num > 3) {
												return false;
											}else {
												return true;
											}
										})
										.collect(Collectors.toList());
		System.out.println(numbers3);
		
		
		// 중복제거, 짝수 데이터 필터링, 내림차순 정렬
		List<Integer> num4 = numbers.stream()
				.distinct().filter(num -> num % 2 != 0)
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());
		System.out.println(num4);
		
		
		
		
	} //med
} //ed



















