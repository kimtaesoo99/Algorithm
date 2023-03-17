import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n+1][2];

            for (int k = 0; k < 2; k++) {
                for (int j = 1; j <= n; j++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            int[][] dp = new int[n+1][2];
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            for (int j = 2; j <= n; j++){
                dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1]) + arr[j][0];
                dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0]) + arr[j][1];
            }
            System.out.println(Math.max(dp[n][0],dp[n][1]));
        }
    }
}
