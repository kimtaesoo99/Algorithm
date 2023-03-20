import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int[] arr;
    static int n;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        backTrack("", m , 0);
        System.out.println(sb);
    }

    private static void backTrack(String result, int count, int pre) {
        if (count == 0) {
            if (!set.contains(result)) {
                set.add(result);
                sb.append(result).append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= pre){
                backTrack(result + arr[i] + " ", count - 1,arr[i]);
            }
        }
    }
}
