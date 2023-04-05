import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static List<Node>[] nodes;
    static int[] distance;
    static boolean[] check;
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            nodes = new ArrayList[n * n];
            distance = new int[n * n];
            check = new boolean[n * n];
            for (int i = 0; i < n * n; i++) {
                nodes[i] = new ArrayList<>();
                distance[i] = Integer.MAX_VALUE;
            }
            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int num = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        int y = i + dy[k];
                        int x = j + dx[k];
                        if (0 <= y && y < n && 0 <= x && x < n) {
                            nodes[num].add(new Node(x % n + y * n, map[y][x]));
                        }
                    }
                    num++;
                }
            }
            dij(0);
            sb.append("Problem " + testCase + ": " + (distance[n * n - 1] + map[0][0]) + "\n");
            testCase++;
        }
        System.out.println(sb);
    }

    private static void dij(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[start] = 0;
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            check[cur.num] = true;
            for (Node next : nodes[cur.num]) {
                if (!check[next.num]) {
                    if (distance[cur.num] + next.link < distance[next.num]) {
                        distance[next.num] = distance[cur.num] + next.link;
                        q.offer(new Node(next.num, distance[next.num]));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int num;
    int link;

    @Override
    public int compareTo(Node node) {
        return this.link - node.link;
    }

    public Node(int num, int link) {
        this.num = num;
        this.link = link;
    }
}


