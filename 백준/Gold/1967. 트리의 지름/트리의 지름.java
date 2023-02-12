import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static List<Node> nodes[];
    static boolean[] visited;
    static int max;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        for(int i = 1; i <= N; i++)nodes[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            nodes[from].add(new Node(to,value));
            nodes[to].add(new Node(from,value));
        }

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(max);
    }

    public static void dfs(int num, int value){
        for(Node node : nodes[num]){
            if(!visited[node.link]){
                visited[node.link] = true;
                dfs(node.link, value + node.value);
            }
        }
        max = Math.max(max,value);
    }

}

class Node{
    public int link;
    public int value;

    public Node(int link, int value){
        this.link = link;
        this.value =value;
    }
}
