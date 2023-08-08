import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n][2];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        System.out.println(findOrder(0, n - 1));
    }

    public static int findOrder(int start, int end) {
        if (start == end) {
            return 0;
        }
        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }
        for (int i = start; i < end; i++) {
            int cost = findOrder(start, i) + findOrder(i + 1, end) + arr[start][0] * arr[i][1] * arr[end][1];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        return dp[start][end];
    }
}