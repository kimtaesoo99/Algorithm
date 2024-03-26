import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static int[][] distance;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra(map);

            System.out.println("Problem " + test++ + ": " + distance[N - 1][N - 1]);
        }
    }

    private static void dijkstra(int[][] map) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(0, 0, 0));

        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], 30000000);
        }

        distance[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node pqNode = pq.poll();

            int y = pqNode.y;
            int x = pqNode.x;

            if (distance[y][x] < pqNode.cost) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int moveY = y + dy[i];
                int moveX = x + dx[i];

                if (0 <= moveY && moveY < N && 0 <= moveX && moveX < N) {
                    if (distance[moveY][moveX] > distance[y][x] + map[moveY][moveX]) {
                        distance[moveY][moveX] = distance[y][x] + map[moveY][moveX];
                        pq.add(new Node(moveY, moveX, distance[moveY][moveX]));
                    }
                }
            }
        }
    }
}

class Node {
    int y;
    int x;
    int cost;

    public Node(int y, int x, int cost) {
        this.y = y;
        this.x = x;
        this.cost = cost;
    }
}