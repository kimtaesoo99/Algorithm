
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static List<Node> nodes[];
    static boolean visited[];
    static int max;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to, value));
            nodes[to].add(new Node(from, value));
        }

        for (int i = 1; i <=N; i++){
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(max);
    }

    public static void dfs(int num, int sum){
        for (Node node : nodes[num]) {
            if (!visited[node.link]){
                visited[node.link] = true;
                dfs(node.link, sum + node.value);
            }
        }
        max = Math.max(max, sum);
    }
}


class Node {
    int link;
    int value;

    public Node(int link, int value) {
        this.link = link;
        this.value = value;
    }
}
