import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer>[] list = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                list[i] = new ArrayList();
            }

            visited = new boolean[n];

            for (int i = 0; i < m; i++) {
                int from = sc.nextInt() - 1;
                int to = sc.nextInt() - 1;
                list[from].add(to);
                list[to].add(from);
            }

            int result = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    result++;
                    find(list, i);
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void find(List<Integer>[] list, int now) {
        for (int l : list[now]) {
            if (!visited[l]) {
                visited[l] = true;
                find(list, l);
            }
        }
    }
}
