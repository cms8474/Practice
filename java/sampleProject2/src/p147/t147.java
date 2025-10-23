package p147;

public class t147 {
	public static void main(String[] args) {
		int[][]  aa = new int[4][];
		aa[0] = new int[4];
		aa[1] = new int[1];
		aa[2] = new int[1];
		aa[3] = new int[4];
		int k = 0;
		
		for(int i=0; i<aa.length ; i++)
			for(int j=0 ; j<aa[i].length ; j++)
				aa[i][j] = k++;
		
		for(int i=0; i<aa.length ; i++) {
			for(int j=0 ; j<aa[i].length ; j++)
				System.out.print(aa[i][j]+" ");
			System.out.println("");
		}
		
	}
}
