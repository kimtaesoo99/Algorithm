import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Main {
    static List<Node>[] nodes;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        nodes = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            String[] info = br.readLine().split(" ");
            int from = Integer.parseInt(info[0]);
            int to = Integer.parseInt(info[1]);
            int value = Integer.parseInt(info[2]);
            nodes[from].add(new Node(to,value));
            nodes[to].add(new Node(from,value));
        }

        String[] sAndT = br.readLine().split(" ");
        int start = Integer.parseInt(sAndT[0]);
        int target = Integer.parseInt(sAndT[1]);

        dij(start);
        System.out.println(distance[target]);
    }

    private static void dij(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start,0));
        distance[start] = 0;
        visited[start] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int now = node.num;
            visited[now] = true;
            for (Node next : nodes[now]) {
                if (!visited[next.num]) {
                    if (distance[next.num] > distance[now] + next.value) {
                        distance[next.num] = distance[now] + next.value;
                        q.offer(new Node(next.num, distance[next.num]));
                    }
                }
            }
        }
    }
}


class Node implements Comparable<Node> {
    int num;
    int value;

    @Override
    public int compareTo(Node n) {
        return this.value - n.value;
    }

    public Node(int num, int value) {
        this.num = num;
        this.value = value;
    }
}
