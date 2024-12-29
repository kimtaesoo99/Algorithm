import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            int time = sc.nextInt();
            int page = sc.nextInt();

            for (int j = n; j >= time; j--) {
                dp[j] = Math.max(dp[j - time] + page, dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}