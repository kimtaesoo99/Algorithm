import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }

    static int dfs(int y, int x) {
        if (y == M - 1 && x == N - 1) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (0 > moveX || 0 > moveY || moveX >= N || moveY >= M) {
                continue;
            }
            if (map[y][x] > map [moveY][moveX]){
                dp[y][x] += dfs(moveY,moveX);
            }
        }
        return dp[y][x];
    }
}
