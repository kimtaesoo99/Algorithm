import java.util.Scanner;

class Solution {

    private static final int[][] moveP = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int[][] moveX = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            max = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    findMax(i, j, map, m, n);
                }
            }
            System.out.println("#" + test_case + " " + max);
        }
    }

    private static void findMax(int y, int x, int[][] map, int m, int n) {
        int sumP = 0;
        int sumX = 0;

        for (int i = 0; i < 4; i++) {
            int nowY = y;
            int nowX = x;

            for (int j = 0; j < m - 1; j++) {
                nowY += moveP[i][0];
                nowX += moveP[i][1];
                if (0 <= nowY && nowY < n && 0 <= nowX && nowX < n) {
                    sumP += map[nowY][nowX];
                }
            }

            nowY = y;
            nowX = x;

            for (int j = 0; j < m - 1; j++) {
                nowY += moveX[i][0];
                nowX += moveX[i][1];
                if (0 <= nowY && nowY < n && 0 <= nowX && nowX < n) {
                    sumX += map[nowY][nowX];
                }
            }
        }
        max = Math.max(max, Math.max(sumP, sumX) + map[y][x]);
    }
}
