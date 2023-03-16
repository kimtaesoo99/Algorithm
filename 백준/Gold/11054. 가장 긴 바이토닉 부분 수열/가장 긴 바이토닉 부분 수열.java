import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] >= max){
                    max = dp[j]+1;
                }
            }
            dp[i] = max;
        }

        int[] reverseDp = new int[n];

        for (int i = n-1; i >= 0; i--){
            int max = 1;
            for (int j = n-1; j > i; j--){
                if (arr[i] > arr[j] && reverseDp[j] >= max){
                    max = reverseDp[j] + 1;
                }
            }
            reverseDp[i] = max;
        }

        for (int i = 0; i < n; i++){
            maxValue = Math.max(dp[i]+reverseDp[i],maxValue);
        }
        System.out.println(maxValue-1);
    }
}
