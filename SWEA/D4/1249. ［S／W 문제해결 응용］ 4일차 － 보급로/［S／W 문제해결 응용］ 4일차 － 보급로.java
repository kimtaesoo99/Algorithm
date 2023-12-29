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
            result = 0;

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = sc.next();
                for (int j = 0; j < n; j++) {
                    int number = line.charAt(j) - '0';
                    map[i][j] = number;
                }
            }

            System.out.println("#" + test_case + " " + bfs(map, n));
        }
    }

    private static int bfs(int[][] map, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        int[][] board = new int[n][n];
        board[0][0] = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int value = map[now[0]][now[1]];

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < n && 0 <= moveX && moveX < n) {
                    if (board[moveY][moveX] > value + now[2]) {
                        board[moveY][moveX] = value + now[2];
                        q.offer(new int[]{moveY, moveX, value + now[2]});
                    }
                }
            }
        }

        return board[n - 1][n - 1];
    }
}
