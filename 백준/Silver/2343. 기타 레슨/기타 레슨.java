import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        int[] arr = new int[n];

        String[] line = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        int left = 1;
        int right = 1000000000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isCan(mid, arr, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static boolean isCan(int mid, int[] arr, int m) {
        int sum = 0;
        int count = 1;

        for (int j : arr) {
            if (mid < j){
                return false;
            }

            sum += j;
            if (sum > mid) {
                sum = j;
                count++;
            }
        }

        return count <= m;
    }
}