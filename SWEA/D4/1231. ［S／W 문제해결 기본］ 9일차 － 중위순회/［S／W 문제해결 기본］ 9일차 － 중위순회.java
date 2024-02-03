import java.util.Scanner;

class Solution {

    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(sc.nextLine());
            Node[] nodes = new Node[n + 1];

            for (int i = 1; i <= n; i++) {
                String[] info = sc.nextLine().split(" ");
                int l = info.length;
                nodes[Integer.parseInt(info[0])] = new Node(info[1],
                        (l >= 3 ? Integer.parseInt(info[2]) : 0),
                        (l >= 4 ? Integer.parseInt(info[3]) : 0));
            }
            sb.append("#").append(test_case).append(" ");
            back(nodes, 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void back(Node[] nodes, int now) {
        if (now == 0) {
            return;
        }
        back(nodes, nodes[now].left);
        sb.append(nodes[now].value);
        back(nodes, nodes[now].right);
    }
}

class Node {
    int left;
    int right;
    String value;

    public Node(String value, int left, int right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value='" + value + '\'' +
                '}';
    }
}