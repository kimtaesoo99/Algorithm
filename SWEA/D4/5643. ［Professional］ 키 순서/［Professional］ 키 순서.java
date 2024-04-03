import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    private static boolean[] visited;
    private static List<Integer>[] list;
    private static List<Integer>[] list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            list = new ArrayList[n + 1];
            list2 = new ArrayList[n + 1];

            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
                list2[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                String[] info = br.readLine().split(" ");
                int a = Integer.parseInt(info[0]);
                int b = Integer.parseInt(info[1]);
                list[a].add(b);
                list2[b].add(a);
            }

            int result = 0;

            for (int i = 1; i <= n; i++) {
                int target = i;
                visited = new boolean[n + 1];

                backTrack(target);
                backTrack2(target);

                int count = 0;

                for (int j = 1; j <= n; j++) {
                    if (visited[j]) {
                        count++;
                    }
                }
                if (count == n) {
                    result++;
                }
            }
            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void backTrack(int now) {
        visited[now] = true;
        if (now == 0) {
            return;
        }

        for (int next : list[now]) {
            if (!visited[next]) {
                backTrack(next);
            }
        }
    }

    private static void backTrack2(int now) {
        visited[now] = true;
        if (now == 0) {
            return;
        }

        for (int next : list2[now]) {
            if (!visited[next]) {
                backTrack2(next);
            }
        }
    }
}