import java.util.*;
import java.io.*;

public class Main {
    private static final int INF = Integer.MAX_VALUE / 16;
    static List<ArrayList<Node>> list;
    static int[] dist;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        list = new ArrayList<>();
        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            list.get(s).add(new Node(d, w));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, destination));

    }

    static int dijkstra(int start, int destination) {
        PriorityQueue<Node> que = new PriorityQueue<Node>();
        boolean[] visit = new boolean[N + 1];

        dist[start] = 0;
        que.offer(new Node(start, 0));

        while( !que.isEmpty() ) {
            Node queNode = que.poll();
            int start_nodeNum = queNode.link;

            if(!visit[start_nodeNum]) {
                visit[start_nodeNum] = true;

                for(Node node : list.get(start_nodeNum)) {

                    if( !visit[node.link] && dist[node.link] > (dist[start_nodeNum] + node.cost) ) {
                        dist[node.link] = dist[start_nodeNum] + node.cost;
                        que.offer(new Node(node.link, dist[node.link]));
                    }
                }
            }
        }

        return dist[destination];
    }

}
class Node implements Comparable<Node> {
    int link;
    int cost;

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }

    public Node(int link, int cost) {
        this.link = link;
        this.cost = cost;
    }
}
