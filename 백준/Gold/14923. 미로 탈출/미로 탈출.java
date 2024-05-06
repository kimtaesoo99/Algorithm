import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static int n;
    private static int m;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        n = Integer.parseInt(info[0]);
        m = Integer.parseInt(info[1]);

        String[] start = br.readLine().split(" ");
        int startY = Integer.parseInt(start[0]) - 1;
        int startX = Integer.parseInt(start[1]) - 1;

        String[] end = br.readLine().split(" ");
        int endY = Integer.parseInt(end[0]) - 1;
        int endX = Integer.parseInt(end[1]) - 1;

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(bfs(startY, startX, endY, endX));
    }

    private static int bfs(int startY, int startX, int endY, int endX) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX, 0, 0});

        boolean[][][] visited = new boolean[n][m][2];
        visited[startY][startX][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == endY && now[1] == endX) {
                return now[3];
            }

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < n && 0 <= moveX && moveX < m) {
                    if (now[2] == 0) { // 벽을 깨본적이 없음
                        if (map[moveY][moveX] == 0 && !visited[moveY][moveX][0]) {
                            q.offer(new int[]{moveY, moveX, 0, now[3] + 1});
                            visited[moveY][moveX][0] = true;
                        } else if (map[moveY][moveX] == 1 && !visited[moveY][moveX][1]) {
                            q.offer(new int[]{moveY, moveX, 1, now[3] + 1});
                            visited[moveY][moveX][1] = true;
                        }
                    } else { // 이제 0으로만 감
                        if (map[moveY][moveX] == 0 && !visited[moveY][moveX][1]) {
                            q.offer(new int[]{moveY, moveX, 1, now[3] + 1});
                            visited[moveY][moveX][1] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }
}