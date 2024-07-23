import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[n + 1] = l;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int left = 0;
        int right = l;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (binarySearch(arr, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    //0 200 701 800 1000
    private static boolean binarySearch(int[] arr, int target, int m) {
        int pre = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pre > target) {
                if (m > 0) {
                    m--;
                    i--;
                    pre += target;
                } else {
                    return false;
                }
            } else {
                pre = arr[i];
            }
        }
        return true;
    }
}
