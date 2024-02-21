import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                back(i, 0);
                visited[i] = false;
            }
            if (result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void back(int now, int depth) {
        if (depth >= 4) {
            result = 1;
            return;
        }

        for (int next : list[now]) {
            if (!visited[next]) {
                visited[next] = true;
                back(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}