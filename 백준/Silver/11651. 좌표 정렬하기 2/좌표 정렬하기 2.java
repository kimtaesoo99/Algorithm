import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();		
		int[][] array = new int[n][2];
		for (int i = 0; i < n; i++) {
			array[i][1] = in.nextInt();
			array[i][0] = in.nextInt();
		}
		Arrays.sort(array, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		for(int i = 0; i < n; i++) {
			System.out.println(array[i][1] + " " + array[i][0]);
		}
	}

}
