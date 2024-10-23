import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[] arr = new int[n];
        int maxTime = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, arr[i]);
        }

        long left = 1;
        long right = (long) maxTime * m;

        while (left + 1 < right) {
            long mid = (left + right) / 2;

            if (can(mid, arr, m)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    private static boolean can(long mid, int[] arr, int m) {
        long count = 0;

        for (int j : arr) {
            count += mid / j;
            if (count >= m){
                return true;
            }
        }

        return count >= m;
    }
}