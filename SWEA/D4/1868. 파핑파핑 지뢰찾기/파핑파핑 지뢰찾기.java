import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    private static int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
    private static int[] dx = {0, -1, 0, 1, 1, -1, 1, -1};
    private static char[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();

            map = new char[n][n];
            visited = new boolean[n][n];
            initMap(n, sc);

            int result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '0' && !visited[i][j]) {
                        result++;
                        bfs(i, j, n);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        result++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void initMap(int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                char value = line.charAt(j);
                map[i][j] = value;
                if (map[i][j] == '*') {
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    continue;
                }

                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int moveY = i + dy[k];
                    int moveX = j + dx[k];

                    if (isCorrectSize(moveY, moveX, n) && map[moveY][moveX] == '*') {
                        count++;
                    }
                }
                map[i][j] = (char) (count + '0');
            }
        }
    }

    private static void bfs(int y, int x, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int k = 0; k < 8; k++) {
                int moveY = now[0] + dy[k];
                int moveX = now[1] + dx[k];

                if (isCorrectSize(moveY, moveX, n) && map[moveY][moveX] != '*' && !visited[moveY][moveX]) {
                    if (map[now[0]][now[1]] != '0') {
                        continue;
                    }
                    visited[moveY][moveX] = true;
                    q.offer(new int[]{moveY, moveX});
                }
            }
        }
    }

    private static boolean isCorrectSize(int moveY, int moveX, int n) {
        return 0 <= moveY && moveY < n && 0 <= moveX && moveX < n;
    }
}
