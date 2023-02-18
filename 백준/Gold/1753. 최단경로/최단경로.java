import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static List<Node>[] nodes;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vAndE = br.readLine().split(" ");
        int n = Integer.parseInt(vAndE[0]);
        int e = Integer.parseInt(vAndE[1]);
        int start = Integer.parseInt(br.readLine());
        nodes = new ArrayList[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];
        for (int i = 0; i <=n; i++){
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0 ; i < e; i++){
            String[] info = br.readLine().split(" ");
            int from  = Integer.parseInt(info[0]);
            int to  = Integer.parseInt(info[1]);
            int value  = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to, value));
        }
        StringBuilder sb= new StringBuilder();
        dij(start);
        for (int i = 1; i <= n; i++){
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void dij(int start){
        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[start] = 0;
        q.offer(new Node(start,0));

        while (!q.isEmpty()){
            Node poll = q.poll();
            visited[poll.end] = true;
            for (Node now : nodes[poll.end]){
                if (!visited[now.end]){
                    if (distance[poll.end] + now.cost < distance[now.end]){
                        distance[now.end] = distance[poll.end] + now.cost;
                        q.offer(new Node(now.end, distance[now.end]));
                    }
                }
            }
        }
    }
}


class Node implements Comparable<Node>{
    public int end;
    public int cost;

    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost- o.cost;
    }
}
