import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node[] nodes = new Node[n + 1];
        nodes[0] = new Node(0, 0, 0, 0);
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(nodes, (Comparator.comparingInt(o -> o.bottom)));

        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (nodes[i].weight > nodes[j].weight) {
                    dp[i] = Math.max(dp[i], dp[j] + nodes[i].height);
                }
            }
            max = Math.max(max, dp[i]);
        }

        Stack<Integer> result = new Stack<>();
        while (n > 0) {
            if (max == dp[n]) {
                result.add(nodes[n].num);
                max -= nodes[n].height;
            }
            n--;
        }

        System.out.println(result.size());
        while (!result.isEmpty()) {
            System.out.println(result.pop());
        }
    }
}

class Node {
    int num;
    int bottom;
    int height;
    int weight;

    public Node(int num, int bottom, int height, int weight) {
        this.num = num;
        this.bottom = bottom;
        this.height = height;
        this.weight = weight;
    }
}