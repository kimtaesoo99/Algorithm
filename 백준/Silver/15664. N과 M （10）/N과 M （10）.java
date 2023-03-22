import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        dfs(0, "", 0);
        System.out.println(sb);
    }

    private static void dfs(int index, String result, int pre) {
        if (index == m) {
            if (!set.contains(result)) {
                set.add(result);
                sb.append(result).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i] >= pre) {
                visited[i] = true;
                dfs(index + 1, result + arr[i] + " ", arr[i]);
                visited[i] = false;
            }
        }
    }
}
