import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static int[] arr;
	public static boolean[] check;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		check = new boolean[N];
		btm(N, M, 0);
		System.out.println(sb);
	}

	public static void btm(int N, int M, int depth) {
		if (depth == M) {
		for (int i=0; i <arr.length; i++) {
				for(int j=0; j<arr.length-1; j++) {
					if(arr[j]>arr[j+1])return;
				}
				sb.append(arr[i]).append(' ');
			}

			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[depth] = i + 1;
				btm(N, M, depth + 1);
				check[i] = false;
			}
		}
	}
}