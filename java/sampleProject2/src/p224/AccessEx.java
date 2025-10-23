package p224;

class Sample {
	public int a;
	private int b;
	int c; //디폴트
	protected int d;
}

class Sub extends Sample{
	public void name() {
		d = 10;
	}
}

public class AccessEx {
	public static void main(String[] args) {
		Sample sample = new Sample();
		sample.a = 10;
		//sample.b = 10;  //불가 (pri!!) 
		sample.c = 10;
		
		
		Sub sub = new Sub();
		sub.name();
		System.out.println(sample.d);
		System.out.println(sub.d);
		
	}

}
