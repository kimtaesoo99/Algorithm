import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = 987654321;
                if(i==j) map[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++){
            String[] str = br.readLine().split(" ");
            int from = Integer.parseInt(str[0]);
            int to = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);
            map[from][to] = Math.min(cost,map[from][to]);
        }

        for(int k = 1; k <= n; k++) {
            for(int i=1; i <= n; i++) {
                for(int j=1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            for (int j = 1; j<=n;j++){
                if (map[i][j]==987654321)sb.append(0).append(" ");
                else sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
