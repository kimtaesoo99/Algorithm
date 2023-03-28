import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test_case; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            for (int j = 1; j <= n; j++) {
                arr[j] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] dp = new int[m + 1];
            for (int k = 1; k <= n; k++) {
                for (int j = 1; j <=m; j++) {
                    if (j - arr[k] > 0) {
                        dp[j] = dp[j] + dp[j-arr[k]];
                    } else if (j - arr[k] == 0) {
                        dp[j]++;
                    }
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.println(sb);
    }
}
