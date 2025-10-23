package sub2;

public class Book {
	// 속성	
	private String	title;
	private String	author;
	private String	isbn;
	private int		availableCopies; // 이용가능 복사본
	
	// 생성자	
	public Book (String title, String author, String isbn, int availableCopies) {
		this.title				=	title;
		this.author				=	author;
		this.isbn				=	isbn;
		this.availableCopies	=	availableCopies;
	} //main ed
	
	
	// 메서드
	public Boolean borrowBook() {
		if(availableCopies>0) {
			availableCopies--;
			return true;
		}else {
			return false;
		}
	}
	
	public void returnBook() {
		availableCopies++;
	}
	
	public void show() {
		System.out.println("title : " + this.title);
		System.out.println("author : " + this.author);
		System.out.println("isbn : " + this.isbn);
		System.out.println("availableCopies : " + this.availableCopies);
	}
	
	// 각 변수getter setter
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	
	
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	

}
