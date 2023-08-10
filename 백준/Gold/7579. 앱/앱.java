import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int costSum = 0;

        int[] memories = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            memories[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            costSum += cost[i];
        }

        int[] dp = new int[costSum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = costSum; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memories[i]);
            }
        }

        for (int i = 0; i <= costSum; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
