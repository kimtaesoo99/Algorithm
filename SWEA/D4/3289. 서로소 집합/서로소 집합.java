import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] parents = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    parents[union(parents, first)] = parents[union(parents, second)];
                } else {
                    if (parents[union(parents, first)] == parents[union(parents, second)]) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int union(int[] parents, int now) {
        if (parents[now] == now) {
            return now;
        }

        return parents[now] = union(parents, parents[now]);
    }
}