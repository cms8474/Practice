package sub2;

/*
 * 날짜 20250714
 * 이름 최민수
 * 내용 캡슐화 실습
 * 
 * 캡슐화(정보은닉, Encapsulation)
 * - 캡슐화는 객체의 속성을 외부에서 참조하지 못하게 객체의 속성을 은닉하는 특성
 * - 클래스의 속성을 반드시 private로 선언
 * - private 선언을 하면 생성자(construcor)로 속성을 초기화
 * - 은닉된 속성(정보)를 안전하게 사용하기 위해 Getter, Setter 사용
 * 
 */
public class encapsuleTest {
	public static void main(String[] args) {
		// 객체 생성
		// 은닉된 속성은 생성자(Constructor)로 초기화
		// sonata.name = "소나타";  <- 외부에서 활용 불가
		car sonata = new car("소나타", "흰색", 0);
		sonata.speedUp(80);
		sonata.speedDown(20);
		sonata.show();
		
		// 개별 속성이 은닉되어 있어 속성 수정 불가
		// = Setter로 수정

		
		car avante = new car("아반테", "검정색", 0);
		avante.speedUp(60);
		avante.speedDown(5);
		avante.show();
		
		avante.setColor("남색");
		avante.show();
		/////////////////////////////////////////////////////////
		// Account 객체 생성&초기화 - 국민은행, 101-11-1001, 김유신, 10000
		/////////////////////////////////////////////////////////
		// 출력 30000, 이름 김유진 수정 
		
		Account kb = new Account("국민은행", "101-11-1001", "김유신", 10000);
		kb.deposit(20000);;
		kb.setName("김유진");
		kb.show();

		/////////////////////////////////////////////////////////
		// Account 객체 생성&초기화 - 우리은행, 101-21-2001, 김춘추, 30000
		/////////////////////////////////////////////////////////
		//출력 50000
		
		Account wr = new Account("우리은행", "101-21-2001", "김춘추", 30000);
		wr.deposit(20000);
		wr.show();
		
		/////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////
		
		Book book1 = new Book("삼국지", "나관중", "10001", 10);
		
		boolean is0k1 = book1.borrowBook();
		
		if(is0k1) {
			System.out.println(book1.getTitle() + "도서대출성공");
		}else {
			System.out.println(book1.getTitle() + "도서대출실패");
		}
		
		book1.show();
		
		/////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////
		
		Book book2 = new Book("명품자바", "황기태", "10002", 1);
		
		boolean is0k2 = book2.borrowBook();
		
		if(is0k2) {
			System.out.println(book2.getTitle() + "도서대출성공");
		}else {
			System.out.println(book2.getTitle() + "도서대출실패");
		}
		
		book2.show();
		
		
	}// main ed
}
