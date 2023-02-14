import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        dp[1] = arr[1];
        int max = dp[1];

        for (int i = 2; i<=n; i++){
            dp[i] = arr[i];
            for (int j = 1; j<i; j++){
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + arr[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
