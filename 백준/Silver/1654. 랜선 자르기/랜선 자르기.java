import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int k = Integer.parseInt(info[0]);
        int n = Integer.parseInt(info[1]);

        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long left = 1;
        long right = Integer.MAX_VALUE;

        while (left <= right) {
            long mid = (right + left) / 2;

            if (isCan(arr, n, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static boolean isCan(int[] arr, int n, long value) {
        long count = 0;

        for (int j : arr) {
            count += (j / value);
        }

        return count >= n;
    }
}
