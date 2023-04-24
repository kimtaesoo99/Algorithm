import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        L = sc.nextInt(); 
        R = sc.nextInt(); 

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int result = 0;

        while (true) {
            int switchingCount = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        switchingCount++;
                        bfs(i, j);
                    }
                }
            }
            if (switchingCount == N * N) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        int sum = map[y][x];
        List<int[]> change = new ArrayList<>();
        change.add(new int[]{y,x});

        while (!q.isEmpty()) {
            int[] move = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                if (validation(moveY, moveX)) {
                    continue;
                }
                int gap = Math.abs(map[moveY][moveX] - map[move[0]][move[1]]);
                if (!visited[moveY][moveX] && L <= gap && gap <= R) {
                    visited[moveY][moveX] = true;
                    change.add(new int[]{moveY, moveX});
                    q.offer(new int[]{moveY, moveX});
                    sum += map[moveY][moveX];
                }
            }
        }
        changeMap(change, sum);
    }

    private static boolean validation(int moveY, int moveX) {
        return !(0 <= moveY && moveY < N && 0 <= moveX && moveX < N);
    }

    private static void changeMap(List<int[]> list, int sum) {
        int changeValue = sum/list.size();
        for (int[] l : list) {
            map[l[0]][l[1]] = changeValue;
        }
    }
}