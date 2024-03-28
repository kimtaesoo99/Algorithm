import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static char[][] map;
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        map = new char[r][c];

        int startY = 0;
        int startX = 0;

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'S') {
                    startY = i;
                    startX = j;
                } else if (map[i][j] == '*') {
                    deque.offer(new int[]{i, j, 0});
                }
            }
        }

        int result = bfs(deque, startY, startX);

        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    private static int bfs(Deque<int[]> deque, int startY, int startX) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startY, startX, 0});
        boolean[][] visited = new boolean[r][c];
        visited[startY][startX] = true;

        int nowDis = 0;

        while (!q.isEmpty() || !deque.isEmpty()) {
            while (!deque.isEmpty()) {
                if (deque.peek()[2] != nowDis) {
                    break;
                }

                int[] info = deque.poll();
                int y = info[0];
                int x = info[1];
                int dis = info[2];

                for (int i = 0; i < 4; i++) {
                    int moveY = y + dy[i];
                    int moveX = x + dx[i];

                    if (!inMap(moveY, moveX)) {
                        continue;
                    }

                    if (map[moveY][moveX] == '.') {
                        map[moveY][moveX] = '*';
                        deque.offer(new int[]{moveY, moveX, dis + 1});
                    }
                }
            }

            while (!q.isEmpty()) {
                if (q.peek()[2] != nowDis) {
                    break;
                }

                int[] info = q.poll();
                int y = info[0];
                int x = info[1];
                int dis = info[2];

                if (map[y][x] == 'D') {
                    return dis;
                }

                for (int i = 0; i < 4; i++) {
                    int moveY = y + dy[i];
                    int moveX = x + dx[i];

                    if (!inMap(moveY, moveX) || visited[moveY][moveX]) {
                        continue;
                    }

                    if (map[moveY][moveX] == '.' || map[moveY][moveX] == 'D') {
                        visited[moveY][moveX] = true;
                        q.offer(new int[]{moveY, moveX, dis + 1});
                    }
                }
            }
            nowDis++;
        }

        return -1;
    }

    private static boolean inMap(int y, int x) {
        return 0 <= y && y < r && 0 <= x && x < c;
    }
}