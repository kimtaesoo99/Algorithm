import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n >= k) {
            System.out.println(n-k);
        }else{
            bfs(n,k);
            System.out.println(min);
        }
    }
    public static void bfs(int n, int k){
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[100001];
        q.offer(new Node(n,0));

        while (!q.isEmpty()){
            Node node = q.poll();
            visited[node.x] = true;

            if (node.x == k)min = Math.min(min,node.time);

            if (node.x*2<=100000 && !visited[node.x*2])q.offer(new Node(node.x*2,node.time));
            if (node.x+1<=100000 && !visited[node.x+1])q.offer(new Node(node.x+1,node.time+1));
            if (node.x-1>=0 && !visited[node.x-1])q.offer(new Node(node.x-1,node.time+1));
        }
    }
}

class Node{
    int x;
    int time;

    public Node(int x, int time) {
        this.x = x;
        this.time = time;
    }
}
