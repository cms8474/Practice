package ex;

public class Calc {
	
	private static Calc instance = new Calc();
	private Calc() {}
	public static Calc getInstance() {
		return instance;
	}
	
	
	
	public int plus(int a, int b) {
		return a+b;
	}

}
