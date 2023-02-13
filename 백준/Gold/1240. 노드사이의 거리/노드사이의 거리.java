import java.util.*;
import java.io.*;

public class Main{
    static List<Node>[] nodes;
    static int distance;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);

        nodes = new ArrayList[N+1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <=N; i++)nodes[i] = new ArrayList<>();
        for(int i = 0 ; i < N-1; i++){
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to,value));
            nodes[to].add(new Node(from,value));
        }

        for(int i =0; i < M; i++){
            distance = 0;
            visited = new boolean[N+1];
            String[] findNode = br.readLine().split(" ");
            visited[Integer.parseInt(findNode[0])] =true;
            dfs(Integer.parseInt(findNode[0]),Integer.parseInt(findNode[1]),0);
            sb.append(distance).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int end, int sum){
        if(start == end){
            distance = sum;
            return;
        }
        for(Node node : nodes[start]){
            if(!visited[node.link]){
                visited[node.link] = true;
                dfs(node.link, end, sum + node.value);
                visited[node.link] = false;
            }
        }
    }
}

class Node{
    public int link;
    public int value;

    public Node(int link, int value){
        this.link = link;
        this.value = value;
    }
}
