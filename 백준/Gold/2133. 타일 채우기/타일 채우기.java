import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[N+1];
        dp[2] = 3;
        int sum = 0;
        for (int i = 4; i <=N; i +=2){
            sum+=dp[i-4]*2;
            dp[i] = dp[i-2]*3+2 + sum;
        }
        System.out.println(dp[N]);
    }
}
