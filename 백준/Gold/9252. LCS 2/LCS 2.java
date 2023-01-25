import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        char[] A = new char[a.length() + 1];
        char[] B = new char[b.length() + 1];
        for (int i = 1; i <= a.length(); i++) A[i] = a.charAt(i - 1);
        for (int i = 1; i <= b.length(); i++) B[i] = b.charAt(i - 1);
        int[][] dp = new int[b.length() + 1][a.length() + 1];

        for (int i = 1; i <= b.length(); i++) {
            for (int j = 1; j <= a.length(); j++) {
                if (B[i] == A[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[b.length()][a.length()]);
        int i = b.length();
        int j = a.length();
        Stack<Character> stack = new Stack<>();
        while (i>=1 && j>=1){
            if (dp[i][j] == dp[i-1][j])i--;
            else if (dp[i][j] == dp[i][j - 1])j--;
            else {
                stack.push(B[i]);
                i--;
                j--;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
