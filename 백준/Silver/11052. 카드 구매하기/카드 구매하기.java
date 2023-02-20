import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];

        String[] info = br.readLine().split(" ");
        for (int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(info[i-1]);
            for (int j = 1; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
