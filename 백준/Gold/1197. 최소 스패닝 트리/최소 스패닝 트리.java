import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[m][3];

        for (int i = 0; i < m; i++) {
            graph[i][0] = sc.nextInt(); //간선 나가는 정점
            graph[i][1] = sc.nextInt(); //간선 들어오는 정점
            graph[i][2] = sc.nextInt(); //가중치
        }

        Arrays.sort(graph, (s1, s2) -> s1[2] - s2[2]);

        int[] parent = new int[n + 1];
        for (int i = 0 ; i < parent.length; i++) {
            parent[i] = i;
        }

        System.out.println(kruskal(graph, parent));
    }

    private static int kruskal(int[][] graph, int[] parent){
        int cost = 0;
        for (int i = 0; i < graph.length; i++) {
            if (find(parent, graph[i][0]) != find(parent,graph[i][1])){
                cost += graph[i][2];
                union(parent,graph[i][0],graph[i][1]);
            }
        }
        return cost;
    }

    private static int find(int[] parent, int n) {
        if (parent[n] == n) {
            return n;
        }
        return find(parent, parent[n]);
    }

    private static void union(int[] parent, int x, int y) {
        x = find(parent,x);
        y = find(parent,y);
        if (x < y) {
            parent[y] = x;
            return;
        }
        parent[x] = y;
    }
}
