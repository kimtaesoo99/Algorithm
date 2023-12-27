import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println("#" + test_case);
            printRotatedMaps(map, n);
        }
    }

    private static void printRotatedMaps(int[][] map, int n) {
        for (int i = 0; i < n; i++) {
            printRotatedMap(map, n, i, 90);
            printRotatedMap(map, n, i, 180);
            printRotatedMap(map, n, i, 270);
            System.out.println();
        }
    }

    private static void printRotatedMap(int[][] map, int n, int row, int degree) {
        for (int j = 0; j < n; j++) {
            switch (degree) {
                case 90:
                    System.out.print(map[n - j - 1][row]);
                    break;
                case 180:
                    System.out.print(map[n - row - 1][n - j - 1]);
                    break;
                case 270:
                    System.out.print(map[j][n - row - 1]);
                    break;
            }
        }
        System.out.print(" ");
    }
}
