package test2;


public class Main {
	public static void main(String[] args) {
		int a = 0;
		for(int i=0; i<args.length ; i++) {
			a += Integer.parseInt(args[i]);
		}
		System.out.println(a);
	}

}
