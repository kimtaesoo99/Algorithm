import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");

        int s = Integer.parseInt(info[0]);
        int k = Integer.parseInt(info[1]);

        int[] arr = new int[s];

        String[] nums = br.readLine().split(" ");

        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

        int maxK = k;
        int left = 0;
        int result = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] % 2 == 1) {
                k--;
            }

            while (k < 0) {
                if (arr[left] % 2 == 1) {
                    k++;
                }
                left++;
            }

            result = Math.max(result, right - left - (maxK - k)+ 1);
        }

        System.out.println(result);
    }
}