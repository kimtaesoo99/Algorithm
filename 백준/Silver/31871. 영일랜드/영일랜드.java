import java.util.Scanner;

/**
 * 0에서 출발해서 모든 놀이기구를 탑승해야함
 * 각 1번씩만 방문가능 -> 방문 배열
 * 최대 값을 구해라
 */

public class Main {

    private static boolean[] visited;
    private static int[][] list;
    private static int max = -1;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n + 1];
        list = new int[n + 1][n + 1]; //from to

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int value = sc.nextInt();

            list[from][to] = Math.max(value, list[from][to]);
        }

        back(0, 0, 0);

        System.out.println(max);
    }

    private static void back(int depth, int now, int sum) {
        if (depth == n && list[now][0] > 0) {
            max = Math.max(max, sum + list[now][0]);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && list[now][i] != 0) {
                visited[i] = true;
                back(depth + 1, i, sum + list[now][i]);
                visited[i] = false;
            }
        }
    }
}
