import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static int sum = 0;

    public int solution(int n, int[][] costs) {
        List<Node>[] nodes = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int costValue = cost[2];
            nodes[from].add(new Node(to, costValue));
            nodes[to].add(new Node(from, costValue));
        }

        mst(nodes, n);

        return sum;
    }

    private void mst(List<Node>[] nodes, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();

            if (visited[nowNode.num]){
                continue;
            }

            visited[nowNode.num] =true;
            sum += nowNode.cost;

            for (Node node : nodes[nowNode.num]) {
                pq.offer(node);
            }
        }
    }
}

class Node implements Comparable<Node> {
    int cost;
    int num;

    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}