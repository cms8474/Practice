package test4.sub4;

public class Member {
	private String	name;
	private String	memberId;
	private Book	borrowedBook;
	
	public Member(String name, String memberId) {
		this.name = name;
		this.memberId = memberId;
		this.borrowedBook = null;
	}
	
	public void borrowBook(Book title) {
		if(borrowedBook==null) {
			title.borrowBook();
			this.borrowedBook = title;
		} else {
			System.out.println(title.getTitle() + " 이미 대출됨");
		}
	}
	public void returnBook(Book title) {
		if(borrowedBook==null) {
			System.out.println("반납할 책 없음");
			this.borrowedBook = title;
		} else {
			title.returnBook();
			this.borrowedBook = null;
			
		}
	}
	public void getMemberInfo() {
		System.out.println("회원명: "+ name);
		System.out.println("아이디: "+ memberId);
		System.out.println("대출한 도서: "+ (borrowedBook==null ? "없음" : borrowedBook.getTitle()));
	}

}
