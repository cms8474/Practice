package test3;
/*
* 날짜 : 2025/07/16
* 이름 : 최민수
* 내용 : 자바 클래스 연습문제
*/
public class Test01 {
	
		private String name;
		private int age;
		
		public Test01(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public void show() {
			System.out.println("================");
			System.out.println("이름 : "+this.name);
			System.out.println("나이 : "+this.age);
			System.out.println("----------------");
		}
}
