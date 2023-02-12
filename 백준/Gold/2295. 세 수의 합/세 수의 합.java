import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        List<Integer> sum = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        Collections.sort(sum);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int a = arr[i] - arr[j];
                int index = binarySearch(sum, a);
                if (index >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    public static int binarySearch(List<Integer> sum, int a) {
        int left = 0;
        int right = sum.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sum.get(mid) == a) {
                return mid;
            } else if (sum.get(mid) < a) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
