import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0, -1, 0, 1, -1, 1, -1, 1};
    private static int[] dy = {1, 0, -1, 0, -1, 1, 1, -1};
    private static boolean[][] visited;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
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

        while (!q.isEmpty()) {
            int[] move = q.poll();

            for (int i = 0; i < 8; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (inMap(moveY, moveX)) {
                    if (map[moveY][moveX] == 1 && !visited[moveY][moveX]) {
                        q.offer(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;
                    }
                }
            }
        }
    }

    private static boolean inMap(int moveY, int moveX) {
        return 0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length;
    }
}