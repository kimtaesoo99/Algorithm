import java.util.Scanner;

class Solution {

    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            result = Integer.MAX_VALUE;

            int[][] list = new int[n + 2][2];
            visited = new boolean[n + 2];

            for (int i = 0; i <= n + 1; i++) {
                list[i][0] = sc.nextInt();
                list[i][1] = sc.nextInt();
            }

            backTracking(list, 0, 0, n, list[0][0], list[0][1]);

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void backTracking(int[][] list, int depth, int sum, int n, int y, int x) {
        if (depth == n) {
            result = Math.min(result, sum + Math.abs(list[1][0] - y) + Math.abs(list[1][1] - x));
            return;
        }

        for (int i = 2; i <= n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(list, depth + 1, sum + Math.abs(list[i][0] - y) + Math.abs(list[i][1] - x), n,
                        list[i][0], list[i][1]);
                visited[i] = false;
            }
        }
    }
}
