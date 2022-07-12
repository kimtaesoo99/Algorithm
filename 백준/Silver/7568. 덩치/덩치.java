import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		int rank[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
					rank[i]++;
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(rank[i]+1);
		}
	}
}

