import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            result = Integer.MAX_VALUE;
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int[] start = new int[2];
            start[0] = sc.nextInt();
            start[1] = sc.nextInt();

            int[] end = new int[2];
            end[0] = sc.nextInt();
            end[1] = sc.nextInt();

            bfs(start, end, map);

            System.out.println("#" + test_case + " " + (result == Integer.MAX_VALUE ? -1 : result));
        }
    }

    private static void bfs(int[] start, int[] end, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});

        int[][] cost = new int[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == end[0] && now[1] == end[1]) {
                result = Math.min(result, now[2]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map.length) {
                    if (map[moveY][moveX] == 1) {
                        continue;
                    }
                    if (map[moveY][moveX] == 0 && cost[moveY][moveX] > now[2] + 1) {
                        cost[moveY][moveX] = now[2] + 1;
                        q.offer(new int[]{moveY, moveX, now[2] + 1});
                    }
                    if (map[moveY][moveX] == 2 && cost[moveY][moveX] > now[2] + (3 - now[2] % 3)) {
                        cost[moveY][moveX] = now[2] + (3 - now[2] % 3);
                        q.offer(new int[]{moveY, moveX, now[2] + (3 - now[2] % 3)});
                    }
                }
            }
        }
    }
}
