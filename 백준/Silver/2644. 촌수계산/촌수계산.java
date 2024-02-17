import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] parents = new int[n + 1];
        int[] count = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int find1 = Integer.parseInt(st.nextToken());
        int find2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parents[b] = a;
        }

        int sum;

        int distance = 1;
        visited[find1] = true;

        while (true) {
            int parent = parents[find1];
            if (parent == 0) {
                break;
            }
            visited[parent] = true;
            count[parent] = distance;
            distance++;
            find1 = parent;
        }
        distance = 1;

        if (visited[find2]) {
            System.out.println(count[find2]);
            return;
        }

        while (true) {
            int parent = parents[find2];
            if (parent == 0) {
                sum = -1;
                break;
            }
            if (visited[parent]) {
                sum = count[parent] + distance;
                break;
            }
            distance++;
            find2 = parent;
        }

        System.out.println(sum);
    }
}