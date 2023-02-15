import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        String[] info = br.readLine().split(" ");
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(info[i-1]);
        }

        int max = 1;
        dp[1] = 1;
        for(int i = 2; i <= N; i++){
            dp[i] = 1;
            for(int j = 1; j<i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
