package p193;

public class Book {
	String title;
	String author;
	
	public Book(String t) {
		title = t;
		author = "미상";
	}
	
	public Book(String t, String a) {
		title = t;
		author = a;
	}
	
	public static void main(String[] args) {
		
		Book littlePrince = new Book("wangza", "seng");
		
		Book loveStory =  new Book("chun");
		
		System.out.println(littlePrince.title + " " + littlePrince.author);
		System.out.println(loveStory.title + " " + loveStory.author);
		
	}

}
