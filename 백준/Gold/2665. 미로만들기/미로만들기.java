import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(0, 0, n));
    }

    private static int bfs(int y, int x, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, 0});

        int[][] visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 2500;
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + now[0];
                int moveX = dx[i] + now[1];

                if (0 <= moveY && moveY < n && 0 <= moveX && moveX < n) {
                    if (map[moveY][moveX] == 1 && visited[moveY][moveX] > now[2]){
                        q.offer(new int[]{moveY, moveX, now[2]});
                        visited[moveY][moveX] = now[2];
                    } else if (map[moveY][moveX] == 0 && visited[moveY][moveX] > now[2] + 1){
                        q.offer(new int[]{moveY, moveX, now[2] + 1});
                        visited[moveY][moveX] = now[2] + 1;
                    }
                }
            }
        }

        return visited[n - 1][n - 1];
    }
}