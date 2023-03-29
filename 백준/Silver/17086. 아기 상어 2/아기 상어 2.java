import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static boolean[][] visited;
    static int[][] distance;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                distance[i][j] = 1000;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    visited = new boolean[n][m];
                    bfs(i, j);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max, distance[i][j]);
            }
        }
        System.out.println(max-1);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        distance[y][x] = 1;

        while (!q.isEmpty()){
            int[] move = q.poll();

            for (int i = 0; i < 8; i++){
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (0<= moveY && moveY < n && 0<=moveX && moveX < m){
                    if (map[moveY][moveX] == 0 && !visited[moveY][moveX]){
                        distance[moveY][moveX] = Math.min(distance[moveY][moveX],
                                distance[move[0]][move[1]] +1);
                        visited[moveY][moveX] = true;
                        q.offer(new int[]{moveY, moveX});
                    }
                }
            }
        }
    }
}
