import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Node>[] nodes;
    static int maxNodeNum;
    static int max;
    static boolean[] visited;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nodes = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++){
            int now = sc.nextInt();
            while (true){
                int link = sc.nextInt();
                if (link==-1)break;
                int cost = sc.nextInt();
                nodes[now].add(new Node(link,cost));
            }
        }
        visited = new boolean[n+1];
        dfs(1,0);

        visited = new boolean[n+1];
        dfs(maxNodeNum,0);

        System.out.println(max);
    }

    private static void dfs(int nodeNum, int length){
        if (length > max){
            maxNodeNum = nodeNum;
            max = length;
        }
        visited[nodeNum] = true;
        for (Node node : nodes[nodeNum]){
            if (!visited[node.link]){
                dfs(node.link, length + node.cost);
            }
        }
    }

}

class Node{
    int link;
    int cost;

    public Node(int link, int cost) {
        this.link = link;
        this.cost = cost;
    }
}
