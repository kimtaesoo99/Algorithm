import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
        int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};

        while (!q.isEmpty()) {
            int[] move = q.poll();

            for (int i = 0; i < 8; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length) {
                    if (map[moveY][moveX] == 1 && !visited[moveY][moveX]) {
                        q.offer(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;
                    }
                }
            }
        }
    }
}
