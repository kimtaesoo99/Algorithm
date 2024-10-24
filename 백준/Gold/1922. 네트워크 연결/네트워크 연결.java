import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Network>[] networks = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            networks[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            networks[Integer.parseInt(line[0])].add(new Network(Integer.parseInt(line[1]), Integer.parseInt(line[2])));
            networks[Integer.parseInt(line[1])].add(new Network(Integer.parseInt(line[0]), Integer.parseInt(line[2])));
        }

        System.out.println(prime(networks));
    }

    private static int prime(List<Network>[] networks) {
        boolean[] visited = new boolean[networks.length];
        PriorityQueue<Network> pq = new PriorityQueue<>();
        pq.offer(new Network(1, 0));

        int count = 0;

        while (!pq.isEmpty()) {
            Network now = pq.poll();

            if (visited[now.end]) {
                continue;
            }

            visited[now.end] = true;
            count += now.value;

            for (Network next : networks[now.end]) {
                if (!visited[next.end]){
                    pq.offer(next);
                }
            }
        }

        return count;
    }
}

class Network implements Comparable<Network> {
    int end;
    int value;

    public Network(int end, int value) {
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Network o) {
        return this.value - o.value;
    }
}