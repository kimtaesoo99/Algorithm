import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int n;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        backTrack("", m);
        System.out.println(sb);
    }

    private static void backTrack(String result, int count) {
        if (count == 0) {
            if (!set.contains(result)) {
                set.add(result);
                sb.append(result).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTrack(result + arr[i] + " ", count - 1);
                visited[i] = false;
            }
        }
    }
}
