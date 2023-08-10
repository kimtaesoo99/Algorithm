import java.util.*;
import java.io.*;

class Main {
    private static int n;
    private static int k;
    private static int[] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cost = new int[n + 1];

            List<Integer>[] list = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }

            int[] inDegree = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(end);
                inDegree[end]++;
            }

            int w = Integer.parseInt(br.readLine());

            topologicalSort(inDegree, list, w);
        }
    }

    static void topologicalSort(int[] inDegree, List<Integer>[] list, int w) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = cost[i];

            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer i : list[node]) {
                result[i] = Math.max(result[i], result[node] + cost[i]);
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        System.out.println(result[w]);
    }
}
