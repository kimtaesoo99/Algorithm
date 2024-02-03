import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {

    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    private static boolean change;
    private static int[][] map;
    private static boolean[][] visited;
    private static int l;
    private static int r;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;

        while (true) {
            visited = new boolean[n][n];
            change = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j, n);
                    }
                }
            }
            if (!change) {
                break;
            }
            result++;
        }

        System.out.println(result);
    }

    private static void bfs(int y, int x, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        boolean[][] open = new boolean[n][n];
        int sum = map[y][x];
        int count = 1;
        open[y][x] = true;
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < n && 0 <= moveX && moveX < n && !open[moveY][moveX] && !visited[moveY][moveX]) {
                    int gap = Math.abs(map[now[0]][now[1]] - map[moveY][moveX]);
                    if (l <= gap && gap <= r) {
                        q.offer(new int[]{moveY, moveX});
                        open[moveY][moveX] = true;
                        sum += map[moveY][moveX];
                        visited[moveY][moveX] = true;
                        count++;
                    }
                }
            }
        }

        if (count == 1) {
            return;
        }

        change = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (open[i][j]) {
                    map[i][j] = sum / count;
                }
            }
        }
    }
}