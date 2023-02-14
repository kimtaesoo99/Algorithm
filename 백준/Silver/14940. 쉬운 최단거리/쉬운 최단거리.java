import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n;
    static int m;
    static int[][] map;
    static int[][] result;
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");
        n = Integer.parseInt(mapSize[0]);
        m = Integer.parseInt(mapSize[1]);
        map = new int[n][m];
        result = new int[n][m];
        int[] start = new int[2];
        for (int i = 0; i < n; i++){
            String[] mapInfo = br.readLine().split(" ");
            for (int j = 0 ; j < m; j++){
                map[i][j] = Integer.parseInt(mapInfo[j]);
                if (map[i][j]==2){
                    start[0]=i;
                    start[1]=j;
                }
            }
        }

        bfs(start[0],start[1]);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                if (result[i][j]==0&&map[i][j]==1)sb.append(-1).append(" ");
                else sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y,x});
        result[y][x] = 0;

        while (!queue.isEmpty()){
            int[] move = queue.poll();
            for (int i = 0; i < 4; i ++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (0<= moveY && moveY <n && 0<= moveX && moveX <m){
                    if (map[moveY][moveX] == 1 && result[moveY][moveX] == 0){
                        result[moveY][moveX] = result[move[0]][move[1]]+1;
                        queue.offer(new int[]{moveY, moveX});
                    }
                }
            }
        }
    }
}
