import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main{
    static List<Node>[] nodes;
    static boolean[] check;
    static int[] distance;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vAndE = br.readLine().split(" ");
        int v = Integer.parseInt(vAndE[0]);
        int e = Integer.parseInt(vAndE[1]);
        nodes = new ArrayList[v+1];
        check = new boolean[v+1];
        distance = new int[v+1];

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i <= v; i++){
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++){
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to, value));
        }

        StringBuilder sb = new StringBuilder();
        dij(start);
        for (int i = 1; i <=v; i++){
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
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
            check[poll.link] = true;
            for(Node now : nodes[poll.link]){
                if (!check[now.link]){
                    if (distance[poll.link] + now.cost < distance[now.link]){
                        distance[now.link] = distance[poll.link] + now.cost;
                        q.offer(new Node(now.link, distance[now.link]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    public int link;
    public int cost;

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }

    public Node(int link, int cost) {
        this.link = link;
        this.cost = cost;
    }
}
