import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];

        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        backTrack("", k);
        System.out.println(set.size());
    }

    private static void backTrack(String result, int count) {
        if (count == 0) {
            set.add(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTrack(result + arr[i], count - 1);
                visited[i] = false;
            }
        }

    }
}
