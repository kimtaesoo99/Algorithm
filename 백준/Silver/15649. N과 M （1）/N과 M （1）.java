import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static StringBuilder sb;
	private static int[] arr;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);

		arr = new int[M];
		visited = new boolean[N + 1];

		combination(N, 0);
		System.out.println(sb);
	}

	private static void combination(int N, int M) {
		if (M == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[M] = i;
				combination(N, M + 1);
				visited[i] = false;
			}
		}
	}
}