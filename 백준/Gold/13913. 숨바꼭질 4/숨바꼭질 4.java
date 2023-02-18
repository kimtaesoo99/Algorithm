import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main{
    static boolean[] visited;
    static Node result;
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n==k){
            System.out.println(0);
            System.out.println(n);
        }else {
            bfs(n,k);
            System.out.println(result.time);
            Stack<Integer> stack = new Stack<>();
            stack.push(k);
            int index = k;
            while (index!=n){
                stack.push(parent[index]);
                index = parent[index];
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static void bfs(int start, int k){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start,0));
        visited = new boolean[100001];
        parent = new int[100001];

        while (!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.x] = true;
            if (node.x == k){
                result = node;
                return;
            }

            if (node.x *2 <=100000 && !visited[node.x*2]){
                queue.add(new Node(node.x *2, node.time +1));
                parent[node.x *2] = node.x;
                visited[node.x *2] = true;
            }
            if (node.x +1 <=100000 && !visited[node.x+1]){
                queue.add(new Node(node.x +1, node.time +1));
                parent[node.x +1] = node.x;
                visited[node.x +1] = true;
            }
            if (node.x -1 >= 0 && !visited[node.x-1]){
                queue.add(new Node(node.x -1, node.time +1));
                parent[node.x -1] = node.x;
                visited[node.x -1] = true;
            }
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
