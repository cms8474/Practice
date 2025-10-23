package test4.sub4;

public class Book {
	private String		title;
	private String		author;
	private String		isbn;
	private boolean		isBorrowd;
	
	public  Book(String title, String author, String isbn) {
		this.title		= title;
		this.author		= author;
		this.isbn		= isbn;
		this.isBorrowd	= false;
	}
	
	public void borrowBook() {
		if(isBorrowd==false) {
			System.out.println("도서 대출: "+ title);
			this.isBorrowd = true;
		} else {
			System.out.println(title + " 이미 대출됨");
		}
	}
	
	public void returnBook() {
		if(isBorrowd==true) {
			System.out.println("도서 반납: "+ title);
			this.isBorrowd = false;
		} else {
			System.out.println(title + " 없음");
		}
	}
	
	public void getBookInfo() {
		System.out.println("도서명: "+ title);
		System.out.println("저자: "+ author);
		System.out.println("ISBN: "+ isbn);
		System.out.println("대출여부: "+ (isBorrowd==false ? "가능" : "불가능"));
	}
	
	
	public String getTitle() {
		return this.title;
	}

}
