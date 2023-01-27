import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] dp = new int[N+1][M + 1];

        for (int i = 1; i<=N; i++){
            int w = sc.nextInt();
            int v = sc.nextInt();

            for (int j = 1; j<=M; j++){
                if (w>j)dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
            }
        }
        System.out.println(dp[N][M]);
    }
}
