import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int count = 0;
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        setWall(0);
        System.out.println(count);
    }

    private static void setWall(int wallCount) {
        if (wallCount == 3) {
            int[][] copyMap = new int[n][m];

            for (int i = 0; i < n; i++) {
                copyMap[i] = map[i].clone();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyMap[i][j] == 2) {
                        bfs(copyMap,i, j);
                    }
                }
            }
            findCount(copyMap);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    visited[i][j] = true;
                    map[i][j] = 1;
                    setWall(wallCount + 1);
                    visited[i][j] = false;
                    map[i][j] = 0;
                }
            }
        }
    }


    private static void bfs(int[][] copyMap, int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});

        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            int[] move = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];
                if (0 > moveY || 0 > moveX || moveY >= n || moveX >= m) {
                    continue;
                }
                if (copyMap[moveY][moveX] == 0 && !visited[moveY][moveX]) {
                    q.offer(new int[]{moveY, moveX});
                    copyMap[moveY][moveX] = 3;
                }
            }
        }
    }

    private static void findCount(int[][] copyMap) {
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    c++;
                }
            }
        }
        count = Math.max(c, count);
    }
}
