import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; ; j++){
                if (i-j*j<0)break;
                else if (i ==j*j)dp[i] = 1;
                else {
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
