import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        map = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];
            }
        }

        boolean can = true;

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (!check(i, j)) {
                        can = false;
                        break loop;
                    }
                }
            }
        }

        System.out.println(can ? "dd" : "BaboBabo");
    }

    private static boolean check(int y, int x) {
        String standard = map[y][x];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        int startY = y;
        int endY = y;
        int startX = x;
        int endX = x;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + now[0];
                int moveX = dx[i] + now[1];

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length) {
                    if (!visited[moveY][moveX] && map[moveY][moveX].equals(standard)) {
                        q.offer(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;

                        startY = Math.min(startY, moveY);
                        endY = Math.max(endY, moveY);
                        startX = Math.min(startX, moveX);
                        endX = Math.max(endX, moveX);
                    }
                }
            }
        }

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (!map[i][j].equals(standard)) {
                    return false;
                } else {
                    visited[i][j] = true;
                }
            }
        }

        return true;
    }
}