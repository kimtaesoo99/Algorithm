import java.util.*;
import java.io.*;

public class Main{
    static List<Node>[] nodes;
    static boolean[] visited;
    static int[] distance;
    static int n;
    static int MAX = 200000000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndE = br.readLine().split(" ");
        n = Integer.parseInt(nAndE[0]);
        int e = Integer.parseInt(nAndE[1]);
        nodes = new ArrayList[n+1];
        distance = new int[n+1];
        for (int i = 0; i <= n; i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++){
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to,value));
            nodes[to].add(new Node(from,value));
        }
        String[] AandB = br.readLine().split(" ");
        int A = Integer.parseInt(AandB[0]);
        int B = Integer.parseInt(AandB[1]);
        // S-A-B-E, S-B-A-E
        dij(1);
        int S_A = distance[A];
        int S_B = distance[B];
        dij(A);
        int A_B = distance[B];
        int A_E = distance[n];
        dij(B);
        int B_A = distance[A];
        int B_E = distance[n];
        int first = S_A + A_B + B_E;
        int second = S_B + B_A + A_E;
        int min = Math.min(first, second);
        System.out.println(min>=200000000?-1:min);
    }
    public static void dij(int start){
        for(int i = 0 ; i <= n; i++){
            distance[i] = MAX;
        }
        visited = new boolean[n+1];

        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[start] = 0;
        q.offer(new Node(start,0));

        while(!q.isEmpty()){
            Node nowNode = q.poll();
            int now = nowNode.end;
            visited[now] = true;
            for(Node node: nodes[now]){
                if(!visited[node.end]){
                    if(distance[now] + node.cost < distance[node.end]){
                        distance[node.end] = distance[now] + node.cost;
                        q.offer(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    public int end;
    public int cost;

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }

    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }
}
