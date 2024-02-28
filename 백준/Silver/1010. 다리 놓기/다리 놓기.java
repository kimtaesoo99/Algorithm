import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		int[][] dp = new int[31][31];

		dp[0][0] = 1;
		for (int i = 1; i <= 30; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1) {
					dp[i][j] = i;
					continue;
				}
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int min = Math.min(n, m);
			int max = Math.max(n, m);
			sb.append(dp[max][min]).append("\n");
		}
		System.out.println(sb);
	}
}