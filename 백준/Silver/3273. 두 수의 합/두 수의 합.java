import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] info = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int count = 0;
        int end = n - 1;
        int value;
        for (int start = 0; start < n; start++) {
            if (start >= end){
                break;
            }
            value = arr[start] + arr[end];
            if (value < x) {
                continue;
            }
            if (value > x) {
                end--;
                start--;
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}
