import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new int[n][n];
        int[] now = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    now = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] o) -> o[2])
                    .thenComparing(o -> o[0])
                    .thenComparing(o -> o[1]));

            boolean[][] visit = new boolean[n][n];

            pq.add(new int[]{now[0], now[1], 0});
            visit[now[0]][now[1]] = true;

            boolean canEat = false;

            while (!pq.isEmpty()) {
                now = pq.poll();

                if (map[now[0]][now[1]] != 0 && map[now[0]][now[1]] < size) {
                    map[now[0]][now[1]] = 0;
                    eat++;
                    move += now[2];
                    canEat = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int moveY = now[0] + dy[i];
                    int moveX = now[1] + dx[i];

                    if (isNotCorrectMap(moveY, moveX, n, visit, size)) {
                        continue;
                    }

                    pq.add(new int[]{moveY, moveX, now[2] + 1});
                    visit[moveY][moveX] = true;
                }
            }

            if (!canEat) {
                break;
            }
            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }

    private static boolean isNotCorrectMap(int moveY, int moveX, int n, boolean[][] visit, int size) {
        return moveY < 0 || moveX < 0 || moveX >= n || moveY >= n || visit[moveY][moveX] || map[moveY][moveX] > size;
    }
}
