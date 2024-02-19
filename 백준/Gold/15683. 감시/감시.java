import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int[][] map;
    private static int[][] visited;
    private static List<int[]> cctv;
    private static int N;
    private static int M;
    private static int result = 64;

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new int[N][M];

        cctv = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new int[]{i, j});
                }
            }
        }

        back(0);
        System.out.println(result);
    }

    private static void back(int index) {
        if (index == cctv.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0 && visited[i][j] == 0) {
                        count++;
                    }
                }
            }
            result = Math.min(count, result);
            return;
        }

        int[] now = cctv.get(index);
        int type = map[now[0]][now[1]];

        if (type == 1) {
            change(now[0], now[1], 0, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);

            change(now[0], now[1], 1, 1);
            back(index + 1);
            change(now[0], now[1], 1, -1);

            change(now[0], now[1], 2, 1);
            back(index + 1);
            change(now[0], now[1], 2, -1);

            change(now[0], now[1], 3, 1);
            back(index + 1);
            change(now[0], now[1], 3, -1);
        } else if (type == 2) {
            change(now[0], now[1], 1, 1);
            change(now[0], now[1], 3, 1);
            back(index + 1);
            change(now[0], now[1], 1, -1);
            change(now[0], now[1], 3, -1);

            change(now[0], now[1], 0, 1);
            change(now[0], now[1], 2, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);
            change(now[0], now[1], 2, -1);
        } else if (type == 3) {
            change(now[0], now[1], 0, 1);
            change(now[0], now[1], 1, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);
            change(now[0], now[1], 1, -1);

            change(now[0], now[1], 1, 1);
            change(now[0], now[1], 2, 1);
            back(index + 1);
            change(now[0], now[1], 1, -1);
            change(now[0], now[1], 2, -1);

            change(now[0], now[1], 2, 1);
            change(now[0], now[1], 3, 1);
            back(index + 1);
            change(now[0], now[1], 2, -1);
            change(now[0], now[1], 3, -1);

            change(now[0], now[1], 3, 1);
            change(now[0], now[1], 0, 1);
            back(index + 1);
            change(now[0], now[1], 3, -1);
            change(now[0], now[1], 0, -1);
        } else if (type == 4) {
            change(now[0], now[1], 0, 1);
            change(now[0], now[1], 1, 1);
            change(now[0], now[1], 2, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);
            change(now[0], now[1], 2, -1);
            change(now[0], now[1], 1, -1);

            change(now[0], now[1], 3, 1);
            change(now[0], now[1], 1, 1);
            change(now[0], now[1], 2, 1);
            back(index + 1);
            change(now[0], now[1], 2, -1);
            change(now[0], now[1], 1, -1);
            change(now[0], now[1], 3, -1);

            change(now[0], now[1], 3, 1);
            change(now[0], now[1], 0, 1);
            change(now[0], now[1], 2, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);
            change(now[0], now[1], 3, -1);
            change(now[0], now[1], 2, -1);

            change(now[0], now[1], 3, 1);
            change(now[0], now[1], 1, 1);
            change(now[0], now[1], 0, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);
            change(now[0], now[1], 1, -1);
            change(now[0], now[1], 3, -1);
        } else {
            change(now[0], now[1], 0, 1);
            change(now[0], now[1], 1, 1);
            change(now[0], now[1], 2, 1);
            change(now[0], now[1], 3, 1);
            back(index + 1);
            change(now[0], now[1], 0, -1);
            change(now[0], now[1], 1, -1);
            change(now[0], now[1], 2, -1);
            change(now[0], now[1], 3, -1);
        }
    }

    private static void change(int y, int x, int dir, int cost) {
        int moveY = y;
        int moveX = x;
        while (true) {
            moveY += dy[dir];
            moveX += dx[dir];
            if (!inMap(moveY, moveX) || map[moveY][moveX] == 6) {
                break;
            }
            visited[moveY][moveX] += cost;
        }
    }

    private static boolean inMap(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}