import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++){
            String[] info = br.readLine().split(" ");
            int start = Integer.parseInt(info[0]);
            int end = Integer.parseInt(info[1]);
            nodes[i] = new Node(start, end);
        }

        Arrays.sort(nodes);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < nodes.length; i++) {
            while (!q.isEmpty()&&q.peek()<=nodes[i].start) {
                q.poll();
            }
            q.offer(nodes[i].end);
            max = Math.max(max, q.size());
        }
        System.out.println(max);
    }
}


class Node implements Comparable<Node>{
    int start;
    int end;

    @Override
    public int compareTo(Node n){
        if (this.start==n.start)return this.end - n.end;
        return this.start-n.start;
    }

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
