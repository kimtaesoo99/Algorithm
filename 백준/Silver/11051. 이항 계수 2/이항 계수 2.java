import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int arr[][] = new int[N+1][N+1];
		arr[0][0] = 1;
		arr[0][1] = 1;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					arr[i][j] = 1;
				}else {
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j])%10007;
				}
			}
		}
		System.out.println(arr[N][K]);
	}
}