import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        char[] A = new char[a.length()+1];
        char[] B = new char[b.length()+1];

        for (int i = 1; i <=a.length(); i++){
            A[i] = a.charAt(i-1);
        }
        for (int i = 1; i <=b.length(); i++){
            B[i] = b.charAt(i-1);
        }
        int[][] dp = new int[b.length()+1][a.length()+1];

        for (int i = 1; i <= b.length(); i++){
            for (int j = 1; j <=a.length(); j++){
                if (B[i] == A[j])dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println(dp[b.length()][a.length()]);
    }
}