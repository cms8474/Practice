package test3;

class King {
	private String name;
	private int year = 0;
	
	public King(int year){
		this("정조");
		this.year = year;
	}
	public King(String name){
		this.name = name;
	}
	public King(String name, int year){
		this.name = name;
		this.year = year;
	}
	public void show() {
		System.out.println("----------------");
		System.out.println("name : "+name);
		System.out.println("year : "+year);
	}
}//Ced
