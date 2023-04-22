import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static int r;
    static int c;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];

        int sY = 0;
        int sX = 0;

        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    sY = i;
                    sX = j;
                }
            }
        }

        int result = bfs(sY, sX);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    private static int bfs(int sY, int sX) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sY, sX});
        int[][] dis = new int[r][c];
        dis[sY][sX] = 1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] move = q.poll();
            char now = map[move[0]][move[1]];

            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (validation(moveY, moveX)) {
                    continue;
                }

                if (now == 'S') {
                    if (map[moveY][moveX] == 'D') {
                        return dis[move[0]][move[1]];
                    }
                    if (map[moveY][moveX] == '.') {
                        map[moveY][moveX] = 'S';
                        q.offer(new int[]{moveY, moveX});
                        dis[moveY][moveX] = dis[move[0]][move[1]] + 1;
                    }
                }

                if (now == '*') {
                    if (map[moveY][moveX] == '.' || map[moveY][moveX] == 'S') {
                        map[moveY][moveX] = '*';
                        q.offer(new int[]{moveY, moveX});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean validation(int moveY, int moveX) {
        return !(0 <= moveY && moveY < r && 0 <= moveX && moveX < c);
    }
}
