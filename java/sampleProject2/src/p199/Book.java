package p199;

public class Book {
	String title;
	String author;
	
	void show() { System.out.println(title + " " + author);}
	
	public Book() {
		this("", "");
		System.out.println("생성자 호출됨");
	}
	
	public Book(String title) {
		this(title, "작가미상");
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public static void main(String[] args) {
		Book littlePrince = new Book("어왕", "쥐페");
		Book loveStory = new Book("춘향");
		Book emptyBook = new Book();
		
		littlePrince.show();
		loveStory.show();
	}
	
}
