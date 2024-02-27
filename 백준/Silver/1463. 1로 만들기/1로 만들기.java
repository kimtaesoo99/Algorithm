import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1000000);
		dp[n] = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(n);

		while (true) {
			int now = q.poll();

			if (dp[1] != 1000000) {
				break;
			}

			if (now % 3 == 0) {
				dp[now / 3] = Math.min(dp[now / 3], dp[now] + 1);
				q.offer(now / 3);
			}

			if (now % 2 == 0) {
				dp[now / 2] = Math.min(dp[now / 2], dp[now] + 1);
				q.offer(now / 2);
			}

			dp[now - 1] = Math.min(dp[now - 1], dp[now] + 1);
			if (now - 1 > 0) {
				q.offer(now - 1);
			}
		}
		System.out.println(dp[1]);
	}
}