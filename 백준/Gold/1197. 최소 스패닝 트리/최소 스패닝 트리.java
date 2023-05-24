import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static List<Node>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        System.out.println(prim(1, n));
    }

    private static int prim(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int v = node.w;
            int cost = node.cost;

            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            sum += cost;

            for (Node link : graph[v]) {
                if (!visited[link.w]) {
                    pq.offer(link);
                }
            }
        }
        return sum;
    }
}

class Node implements Comparable<Node> {
    int w;
    int cost;

    public Node(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}