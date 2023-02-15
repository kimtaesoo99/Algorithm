import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i <= n; i++)dp[i][1] =1;
        for (int i = 1; i <= k; i++)dp[0][i] =1;

        for (int i =1; i<=n; i++){
            for (int j = 1; j<=k; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %=1000000000;
            }
        }
        System.out.println(dp[n][k]);
    }
}
