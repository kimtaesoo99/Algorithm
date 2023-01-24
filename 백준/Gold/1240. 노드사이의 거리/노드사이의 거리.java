import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Node>[] list;
    static int[] cost;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList[n+1];
        cost = new int[n+1];
        for(int i=1; i<n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v,w));
            list[v].add(new Node(u,w));
        }
        for(int i=0; i<m; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();
            dfs(to, -1, from, 0);
            System.out.println(answer);
        }
    }

    static void dfs(int to, int pa, int from, int cost) {
        if(to == from) {
            answer = cost;
        }
        for(Node n : list[to]) {
            if(n.to != pa) {
                dfs(n.to, to, from, cost+n.cost);
            }
        }
    }

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
