import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int index) {
        if (index == n) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[index] = i + 1;
                dfs(index + 1);
                visited[i] = false;
            }
        }
    }
}
