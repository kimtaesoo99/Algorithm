import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i, j;

        List<Integer>[] list = new ArrayList[n+1];
        for(i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int[] parents = new int[n+1];

        dfs(list, parents, 1, 0);

        for(j=2;j<=n; j++) {
            System.out.println(parents[j]);
        }
    }

    private static void dfs(List<Integer>[] list, int[] parents, int start, int parent) {
        parents[start] = parent;
        for(int item : list[start]) {
            if(item != parent) dfs(list, parents, item, start);
        }
    }
}
