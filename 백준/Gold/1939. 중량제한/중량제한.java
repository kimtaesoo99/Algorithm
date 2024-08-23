import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    private static boolean[] visited;
    private static boolean isCan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        int left = 1;
        int right = 1;

        List<Node>[] list = new List[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int value = Integer.parseInt(line[2]);

            list[from].add(new Node(to, value));
            list[to].add(new Node(from, value));
            right = Math.max(right, value);
        }

        String[] target = br.readLine().split(" ");
        int now = Integer.parseInt(target[0]);
        int end = Integer.parseInt(target[1]);

        while (left <= right) {
            int mid = (left + right) / 2;
            isCan = false;
            visited = new boolean[n + 1];

            can(mid, list, now, end);

            if (isCan) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static void can(int mid, List<Node>[] node, int now, int end) {
        if (isCan) {
            return;
        }

        if (now == end) {
            isCan = true;
            return;
        }

        for (Node n : node[now]) {
            if (!visited[n.next] && n.value >= mid) {
                visited[n.next] = true;
                can(mid, node, n.next, end);
            }
        }
    }
}

class Node {

    int next;
    int value;

    public Node(int next, int value) {
        this.next = next;
        this.value = value;
    }
}