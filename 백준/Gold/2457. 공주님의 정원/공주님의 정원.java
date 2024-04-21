import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int startM = sc.nextInt();
            int startD = sc.nextInt();
            int endM = sc.nextInt();
            int endD = sc.nextInt();
            nodes[i] = new Node(startM * 100 + startD, endM * 100 + endD);
        }

        Arrays.sort(nodes);

        int start = 301;
        int end = 1201;
        int max = 0;
        int index = 0;
        int count = 0;

        while (start < end) {
            boolean isFind = false;

            for (int i = index; i < nodes.length; i++) {
                if (nodes[i].start > start) {
                    break;
                }

                if (max < nodes[i].end) {
                    isFind = true;
                    index = i + 1;
                    max = nodes[i].end;
                }
            }

            if (isFind) {
                start = max;
                count++;
            } else {
                break;
            }
        }

        if (max < end) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
}

class Node implements Comparable<Node> {

    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return this.start - o.start;
    }
}