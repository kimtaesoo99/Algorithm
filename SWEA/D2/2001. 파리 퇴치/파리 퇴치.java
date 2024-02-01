import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] map = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] sum = new int[n + 1][n + 1];

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					sum[i][j] = map[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
				}
			}

			int result = 0;

			for (int i = m; i <= n; i++) {
				for (int j = m; j <= n; j++) {
					result = Math.max(result, sum[i][j] - sum[i - m][j] - sum[i][j - m] + sum[i - m][j - m]);
				}
			}

			sb.append("#").append(test_case).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}