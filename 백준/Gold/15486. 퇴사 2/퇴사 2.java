import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n + 2][2];
        int[] dp = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            schedule[i][0] = t;
            schedule[i][1] = p;
        }

        int max = -1;
        for (int i = 1; i <= n + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int next = i + schedule[i][0];
            int cost = schedule[i][1];
            if (next < n + 2) {
                dp[next] = Math.max(dp[next], max + cost);
            }
        }

        System.out.print(dp[n + 1]);

    }
}