import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int c = Integer.parseInt(info[1]);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (can(mid, arr, c)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(right);
    }

    private static boolean can(int mid, int[] arr, int c) {
        int count = 1;
        int pre = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pre >= mid) {
                count++;
                pre = arr[i];
            }
        }

        return count < c;
    }
}