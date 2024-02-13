import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp = new int[5001];
		dp[3] = 1;
		dp[5] = 1;

		for (int i = 6; i <= 5000; i++) {
			int i3 = dp[i - 3];
			int i5 = dp[i - 5];
			if (i3 == 0 && i5 == 0) {
				continue;
			} else if (i3 == 0) {
				dp[i] = i5 + 1;
			} else if (i5 == 0) {
				dp[i] = i3 + 1;
			} else {
				dp[i] = Math.min(i3, i5) + 1;
			}
		}

		int result = dp[Integer.parseInt(br.readLine())];
		System.out.println(result == 0 ? -1 : result);
	}
}