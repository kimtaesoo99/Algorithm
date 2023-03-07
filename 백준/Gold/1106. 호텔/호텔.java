import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] dp = new int[c+101];
        Arrays.fill(dp,987654321);
        dp[0] = 0;
        for (int i = 0; i < n; i++){
            int cost = sc.nextInt();
            int people = sc.nextInt();
            for (int j = people; j < c+101; j++){
                dp[j] = Math.min(dp[j] , dp[j-people] + cost);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = c; i < c+101; i++){
            min = Math.min(dp[i],min);
        }
        System.out.println(min);
    }
}
