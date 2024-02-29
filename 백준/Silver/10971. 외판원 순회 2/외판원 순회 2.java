import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] map;
	private static boolean[] visited;
	private static int max = Integer.MAX_VALUE;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			visited[i] = true;
			back(0, 0, i, i);
			visited[i] = false;
		}

		System.out.println(max);
	}

	private static void back(int depth, int sum, int now, int start) {
		if (depth == n - 1) {
			if (map[now][start] != 0) {
				max = Math.min(max, sum + map[now][start]);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i] && map[now][i] != 0) {
				visited[i] = true;
				back(depth + 1, sum + map[now][i], i, start);
				visited[i] = false;
			}
		}
	}
}