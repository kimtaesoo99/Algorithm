import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] apt = new int[15][15];
 
		for(int i = 0; i < 15; i++) {
			apt[i][1] = 1;
			apt[0][i] = i;
		}
		for(int i1 = 1; i1 < 15; i1 ++) {
 
			for(int i2 = 2; i2 < 15; i2++) {
				apt[i1][i2] = apt[i1][i2 - 1] + apt[i1 - 1][i2];
			}
		}
		
		int T = in.nextInt();
		
		for(int i3 = 0; i3 < T; i3++) {
			int k = in.nextInt();
			int n = in.nextInt();
			System.out.println(apt[k][n]);
		}
	}
}