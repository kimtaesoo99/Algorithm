import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int minus = Integer.MIN_VALUE;
        int plus = Integer.MAX_VALUE;
        int gap = Integer.MAX_VALUE;

        int left = 0;
        int right = n-1;
        while (left < right){
            int g = arr[left] + arr[right];

            if (Math.abs(gap) > Math.abs(g)) {
                gap = g;
                minus = arr[left];
                plus = arr[right];
            }
            if (g <0)left++;
            else right--;

        }

        System.out.println(minus +" " + plus);

    }
}
