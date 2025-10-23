package sub4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * date 25 0724
 * name minsu choi
 * text java MapStream practice
 */

class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

public class MapStreamTest {
	public static void main(String[] args) {
		
		
		// 불변 리스트
		List<Person> persons = List.of(
										new Person("김유신",23),
										new Person("김춘추", 21),
										new Person("장보고",33),
										new Person("강감찬",43),
										new Person("이순신",53));
		
		// persons.add(new Person("adsf", 22)); 실행오류 발생(=불변리스트에 요소 추가 불가)
		
		// mapXXX : 컬렉션(리스트) 원소를 다른 원소로 변환
		persons.stream().map((person) -> {
						return person.getName();
				}).forEach(name ->{
						System.out.println(name);
				});
		
		
		int total = persons.stream().mapToInt(Person::getAge).sum();
		System.out.println("total: " + total);
		
		
		// flatmapXXX : 원소를 다수의 다른 원소로 변환
		List<String> fruits = List.of("Apple,Banana","Cherry,Grape", "Orange,Mango");
		List<String> result = fruits.stream()
									   .flatMap(line -> {
														String[] values = line.split(",");
														return Arrays.stream(values);
														})
									   .collect(Collectors.toList());
		System.out.println(result);
	}//med
}//ed












