import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            Island[] islands = new Island[n];
            boolean[] visited = new boolean[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                islands[i] = new Island(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                islands[i].y = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());

            PriorityQueue<Node> pq = new PriorityQueue<>();

            long sum = 0;
            int count = 0;

            pq.offer(new Node(0, 0));

            while (!pq.isEmpty()) {
                Node now = pq.poll();

                if (visited[now.id]) {
                    continue;
                }

                visited[now.id] = true;
                sum += now.cost;
                count++;

                if (count == n) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    if (visited[i]) {
                        continue;
                    }

                    long cost = islands[now.id].getDistance(islands[i]);
                    pq.offer(new Node(i, cost));
                }
            }
            sb.append("#").append(test).append(" ").append(Math.round(sum * e)).append("\n");
        }
        System.out.print(sb);
    }
}

class Island {
    int x;
    int y;

    Island(int x) {
        this.x = x;
    }

    long getDistance(Island p) {
        long gapX = this.x - p.x;
        long gapY = this.y - p.y;
        return gapX * gapX + gapY * gapY;
    }
}

class Node implements Comparable<Node> {
    int id;
    long cost;

    public Node(int id, long cost) {
        this.id = id;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.cost, o.cost);
    }
}