import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 일단 초기화 시킴, 이후에 간선, 방문여부, 결과도시, 결과 비용 만듦 비용 최고로 높여서 진행. 맨처음 start 넣고, 이후 인접한거 방문여부 보고 true만들고 돌리면서 비용이 더 싸다면 바꿔주고,
 * 결과도시 초기화하고 추가해줌
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n + 1];
        List<Node>[] nodes = new ArrayList[n + 1]; // 간선
        int[] cost = new int[n + 1];
        List<Integer>[] city = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
            city[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost2 = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, cost2));
        }

        String[] info = br.readLine().split(" ");

        int start = Integer.parseInt(info[0]);
        int end = Integer.parseInt(info[1]);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        city[start].add(start);
        cost[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (cost[now.end] < now.cost) {
                continue;
            }

            if (!visited[now.end]) {
                visited[now.end] = true;
            }

            for (Node next : nodes[now.end]) {
                if (!visited[next.end] && now.cost + next.cost <= cost[next.end]) {
                    cost[next.end] = now.cost + next.cost;
                    city[next.end].clear();

                    for (int i = 0; i < city[now.end].size(); i++) {
                        city[next.end].add(city[now.end].get(i));
                    }

                    city[next.end].add(next.end);
                    pq.offer(new Node(next.end, cost[next.end]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cost[end]).append("\n");
        sb.append(city[end].size()).append("\n");
        for (int i = 0; i < city[end].size(); i++) {
            sb.append(city[end].get(i)).append(" ");
        }

        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    int end;
    int cost;

    public Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}