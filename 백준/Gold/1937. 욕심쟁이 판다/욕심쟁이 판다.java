import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n ; j++){
               max = Math.max(max, dfs(i,j));
            }
        }
        System.out.println(max);
    }

    static int dfs(int y, int x){
        if (dp[y][x] != 0)return dp[y][x];

        dp[y][x] = 1;

        for (int i = 0; i< 4; i++){
            int moveY = y + dy[i];
            int moveX = x + dx[i];

            if (0<= moveY && moveY < map.length && 0<= moveX && moveX <map.length){
                if (map[moveY][moveX] > map[y][x]){
                    dp[y][x] = Math.max(dp[y][x] , dfs(moveY,moveX) + 1);
                }
            }
        }
        return dp[y][x];
    }
}

