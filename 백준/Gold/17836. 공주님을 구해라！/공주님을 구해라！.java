import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(info[j]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0, 0}); // y, x, get, distance

        boolean[][][] visited = new boolean[n][m][2];
        int fastDis = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                fastDis = Math.min(fastDis, now[3]);
            }

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + now[0];
                int moveX = dx[i] + now[1];

                if (0 <= moveX && moveX < m && 0 <= moveY && moveY < n) {
                    if (visited[moveY][moveX][now[2]]) {
                        continue;
                    }

                    // 벽
                    if (map[moveY][moveX] == 1 && !visited[moveY][moveX][now[2]] && now[2] == 1) {
                        visited[moveY][moveX][now[2]] = true;
                        q.offer(new int[]{moveY, moveX, now[2], now[3] + 1});
                    }

                    // 길
                    if (map[moveY][moveX] == 0 && !visited[moveY][moveX][now[2]]) {
                        visited[moveY][moveX][now[2]] = true;
                        q.offer(new int[]{moveY, moveX, now[2], now[3] + 1});
                    }

                    // 칼
                    if (map[moveY][moveX] == 2 && !visited[moveY][moveX][now[2]]) {
                        visited[moveY][moveX][now[2]] = true;
                        q.offer(new int[]{moveY, moveX, 1, now[3] + 1});
                    }
                }
            }
        }

        if (fastDis > k) {
            System.out.println("Fail");
        } else {
            System.out.println(fastDis);
        }

    }
}