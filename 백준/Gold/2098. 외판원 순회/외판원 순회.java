import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int cannotMove = 17 * 1000000 + 1;
    static final int notVisit = cannotMove * 2;
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
            Arrays.fill(dp[i], notVisit);
        }

        System.out.println(tsp(0, 0));
    }

    static int tsp(int now, int visited) {
        visited = visited | (1 << now);

        if (visited == (1 << n) - 1) {
            if (arr[now][0] == 0) {
                return cannotMove;
            }
            return arr[now][0];
        }

        if (dp[now][visited] != notVisit) {
            return dp[now][visited];
        }

        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) == 0 && arr[now][next] != 0) {
                int temp = tsp(next, visited) + arr[now][next];
                dp[now][visited] = Math.min(dp[now][visited], temp);
            }
        }

        return dp[now][visited];
    }
}
