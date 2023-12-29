import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            int target1 = sc.nextInt();
            int target2 = sc.nextInt();

            result = 0;

            List<Integer>[] lists = new ArrayList[v + 1];

            for (int i = 0; i <= v; i++) {
                lists[i] = new ArrayList<>();
            }

            int[] parents = new int[v + 1];

            for (int i = 0; i < e; i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();
                parents[child] = parent;
                lists[parent].add(child);
            }

            int commonParent = findCommonParent(target1, target2, parents);
            findNodeCount(commonParent, lists);
            System.out.println("#" + test_case + " " + commonParent + " " + result);
        }
    }

    private static int findCommonParent(int target1, int target2, int[] parents) {
        boolean[] visited = new boolean[parents.length];
        while (target1 != 0) {
            visited[target1] = true;
            target1 = parents[target1];
        }

        while (true) {
            if (visited[target2]) {
                return target2;
            }
            visited[target2] = true;
            target2 = parents[target2];
        }
    }

    private static void findNodeCount(int commonParent, List<Integer>[] lists) {
        result++;
        for (int next : lists[commonParent]) {
            findNodeCount(next, lists);
        }
    }
}
