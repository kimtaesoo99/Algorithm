
import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N+1][N+1];
        for(int i = 1; i<= N; i++){
            for(int j = 1; j<= N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i==1&&j==1)dp[i][j] = map[i][j];
                else if(i ==1)dp[i][j] = dp[i][j-1] + map[i][j];
                else if(j==1)dp[i][j] = dp[i-1][j] + map[i][j];
                else{
                    dp[i][j] = map[i][j] + dp[i-1][j] + dp[i][j-1]-dp[i-1][j-1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< M; i++){
            int preY = sc.nextInt();
            int preX = sc.nextInt();
            int Y = sc.nextInt();
            int X = sc.nextInt();
            sb.append(dp[Y][X]-dp[Y][preX-1]-dp[preY-1][X] + dp[preY-1][preX-1]).append("\n");
        }
        System.out.println(sb);
    }
}


